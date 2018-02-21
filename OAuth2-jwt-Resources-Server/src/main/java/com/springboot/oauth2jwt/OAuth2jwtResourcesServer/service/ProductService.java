package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product findIdproduct(String idproduct);

    List<Product> findAll();

    Product disabled(Product product);
}
