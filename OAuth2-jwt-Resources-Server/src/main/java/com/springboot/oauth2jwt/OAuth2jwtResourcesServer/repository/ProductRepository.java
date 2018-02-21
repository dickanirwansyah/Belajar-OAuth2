package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.repository;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>{
}
