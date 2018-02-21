package com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.security;

import com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.entity.Role;
import com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.entity.Users;
import com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component
@Transactional
public class CustomUserDetailsService implements UserDetailsService{

    private final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(final String login){

        log.debug("Authenticating {} ", login);

        String lowerCase = login.toLowerCase();

        Users usersFromEntity;
        if(lowerCase.contains("@")){
            usersFromEntity = usersRepository.findByEmail(lowerCase);
        }else{
            usersFromEntity = usersRepository.findByUsernameCaseInsensitive(lowerCase);
        }

        if(usersFromEntity == null){
            throw new UsernameNotFoundException("Maaf Pengguna dengan user "+lowerCase+
                    "tidak terdaftar di database");
        }else if(!usersFromEntity.isActivated()){
            throw new CustomUserNotActiveException("Maaf pengguna dengan user "+lowerCase+
                    "status tidak aktive harap hubungi admin");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Role role : usersFromEntity.getRoleList()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        //login dengan username & password tampilkan role posisi
        return new User(usersFromEntity.getUsername(), usersFromEntity.getPassword(), grantedAuthorities);
    }
}
