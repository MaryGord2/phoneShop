package ru.specialist.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		init();
	}
	
	 @PostConstruct
	    public static void init(){
	      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	    }

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/assets/**")) {
			registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		}
	}
}
