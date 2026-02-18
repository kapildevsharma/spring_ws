package com.devglan.rolebasedoauth2.service.impl;

import com.devglan.rolebasedoauth2.dao.RoleDao;
import com.devglan.rolebasedoauth2.dao.UserDao;
import com.devglan.rolebasedoauth2.dto.UserDto;
import com.devglan.rolebasedoauth2.model.Role;
import com.devglan.rolebasedoauth2.model.RoleType;
import com.devglan.rolebasedoauth2.model.User;
import com.devglan.rolebasedoauth2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Transactional is a Java annotation used in Spring Framework to manage database transactions declaratively. It simplifies transaction management by abstracting away the boilerplate code required to begin, commit, or rollback transactions. When a method is annotated with @Transactional, Spring automatically manages the transaction boundaries for that method.
When a method annotated with @Transactional is called, Spring initiates a new transaction (if one doesn't already exist) before the method execution. If the method completes successfully, the transaction is committed, persisting the changes to the database. However, if an exception is thrown during the method execution, the transaction is rolled back, discarding any changes made within the transaction. This ensures atomicity, consistency, isolation, and durability (ACID) properties of database operations.
@Transactional can be applied at both the class and method levels. When applied at the class level, it applies to all public methods within that class. It's generally used in service layer classes to ensure that business logic operations are executed within a transaction. 

 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userDao.findByUsername(userId);
        if(user == null){
            log.error("Invalid username or password.");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        Set<GrantedAuthority> grantedAuthorities = getAuthorities(user);


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    private Set<GrantedAuthority> getAuthorities(User user) {
        Set<Role> roleByUserId = user.getRoles();
        final Set<GrantedAuthority> authorities = roleByUserId.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().toString().toUpperCase())).collect(Collectors.toSet());
        return authorities;
    }

    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(user -> users.add(user.toUserDto()));
        return users;
    }

    @Override
    public User findOne(long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void delete(long id) {
        userDao.deleteById(id);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User userWithDuplicateUsername = userDao.findByUsername(userDto.getUsername());
        if(userWithDuplicateUsername != null && userDto.getId() != userWithDuplicateUsername.getId()) {
            log.error(String.format("Duplicate username %", userDto.getUsername()));
            throw new RuntimeException("Duplicate username.");
        }
        User userWithDuplicateEmail = userDao.findByEmail(userDto.getEmail());
        if(userWithDuplicateEmail != null && userDto.getId() != userWithDuplicateEmail.getId()) {
            log.error(String.format("Duplicate email %", userDto.getEmail()));
            throw new RuntimeException("Duplicate email.");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        List<RoleType> roleTypes = new ArrayList<>();
        userDto.getRole().stream().map(role -> roleTypes.add(RoleType.valueOf(role)));
        user.setRoles(roleDao.find(userDto.getRole()));
        userDao.save(user);
        return userDto;
    }
}
