package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category disabledCategory(Category category);

    Category findIdcategory(String idcategory);

    List<Category> findAll();
}
