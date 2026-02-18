
public class Interview {
	public static void main(String[] args) {
		Person person = new PersonBuilder().setName("Shankar").setAge(10).build();
		System.out.println(person.getName()+" and "+person.getAge()+" "+person.getAddress());
	}
}


class Person{
	private String name;
	private int age;
	private String address;
	
	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
}

class PersonBuilder{
	private String name;
	private int age;
	private String address;
	
	/**
	 * @param name the name to set
	 */
	public PersonBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * @param age the age to set
	 */
	public PersonBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	
	/**
	 * @param address the address to set
	 */
	public PersonBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public Person build() {
		return new Person(name, age, address);
	}
	
}


