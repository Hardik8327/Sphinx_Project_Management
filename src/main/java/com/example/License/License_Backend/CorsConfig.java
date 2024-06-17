package com.example.License.License_Backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200") // Specify the origin of your Angular application
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods
	                .allowedHeaders("*"); // Specify the allowed headers
	    }
}
