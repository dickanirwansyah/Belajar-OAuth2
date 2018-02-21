package com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class ConfigurationOAuth2 extends AuthorizationServerConfigurerAdapter{


    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private ConfigurationJdbc configurationJdbc;

    @Value("${security.oauth2.resource.jwt.key-uri}")
    private String signingkey;

    @Value("${security.oauth2.resource.jwt.key-value}")
    private String verifierkey;

    //Oauth2 Jwt Access token converter
    @Bean
    public JwtAccessTokenConverter tokenEnhacer(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signingkey);
        converter.setVerifierKey(verifierkey);
        return converter;
    }

    //Jwt token store
    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(tokenEnhacer());
    }

    //authentication manager
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
        throws Exception{

        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(tokenEnhacer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer serverSecure)
            throws Exception{
        serverSecure
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    //Oauth client dengan database
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)throws Exception{

        clients
                .jdbc(configurationJdbc.dataSource());
    }
}
