package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Product;

import java.util.List;

public interface ProductDao {

    Product createProduct(Product product);

    Product disabledProduct(Product product);

    List<Product> findAll();

    Product findId(String idproduct);
}
