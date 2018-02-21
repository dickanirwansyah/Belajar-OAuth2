package com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.repository;

import com.springboot.oauth2jwt.OAuth2jwtAuthorizationserver.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long>{

    @Query("SELECT u FROM Users u WHERE LOWER(u.username) = LOWER(:username)")
    Users findByUsernameCaseInsensitive(@Param("username")String username);

    @Query
    Users findByEmail(String email);

    @Query
    Users findByEmailAndActivationKey(String email, String activationKey);

    @Query
    Users findByEmailAndResetPasswordKey(String email, String resetPasswordKey);
}
