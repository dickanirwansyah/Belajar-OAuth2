package com.springboot.oauth2jwt.OAuth2jwtResourcesServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class OAuth2JwtResourcesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2JwtResourcesServerApplication.class, args);
	}
}
