package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Category;

import java.util.List;

public interface CategoryDao {

    Category createCategory(Category category);

    Category disabledCategory(Category category);

    Category findIdcategory(String idcategory);

    List<Category> findAll();
}
