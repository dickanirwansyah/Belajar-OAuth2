package com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class OAuth2JwtAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2JwtAuthorizationServerApplication.class, args);
	}
}
