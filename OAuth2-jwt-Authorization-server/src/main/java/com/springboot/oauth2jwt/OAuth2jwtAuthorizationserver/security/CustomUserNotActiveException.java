package com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.security;

import org.springframework.security.core.AuthenticationException;

public class CustomUserNotActiveException extends AuthenticationException {

    public CustomUserNotActiveException(String msg, Throwable t) {
        super(msg, t);
    }

    public CustomUserNotActiveException(String msg) {
        super(msg);
    }
}
