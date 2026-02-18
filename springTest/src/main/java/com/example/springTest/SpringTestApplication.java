package com.example.springTest;

import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SpringTestApplication {

    private static final Logger logger = LogManager.getLogger(SpringTestApplication.class);
	
	public static void main(String[] args) {
		logger.info("Application started");
		/* fires up a Spring container and auto-configures beans. */
	//	SpringApplication.run(SpringTestApplication.class, args);
		
		
		SpringApplication app = new SpringApplication(SpringTestApplication.class);
		ConfigurableEnvironment environment = app.run(args).getEnvironment();
        environment.setRequiredProperties("server.port", "8083");
    //    app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
        
	}
}

//for war file 
/*
* @SpringBootApplication public class SpringTestApplication extends
* SpringBootServletInitializer {
* 
* @Override protected SpringApplicationBuilder
* configure(SpringApplicationBuilder application) { return
* application.sources(SpringTestApplication.class); }
* 
* public static void main(String[] args) {
* SpringApplication.run(SpringTestApplication.class, args); } }
*/

