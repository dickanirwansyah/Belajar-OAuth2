package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.repository;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String>{
}
