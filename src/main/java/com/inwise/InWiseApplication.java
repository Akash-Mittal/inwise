package com.inwise;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
@Configuration
public class InWiseApplication {


	public static void main(String[] args) {
		SpringApplication.run(InWiseApplication.class, args);
	}

	   @Bean
	    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
	        Properties props = new Properties();
	        props.put("resource.loader", "class");
	        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    		VelocityEngine vengine = new VelocityEngine();
    		vengine.init(props);
    		return vengine;
	    }

}
