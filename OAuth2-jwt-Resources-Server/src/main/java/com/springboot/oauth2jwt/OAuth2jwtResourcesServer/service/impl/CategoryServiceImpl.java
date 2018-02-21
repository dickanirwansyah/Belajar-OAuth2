package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service.impl;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao.CategoryDao;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Category;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category createCategory(Category category) {
       return categoryDao.createCategory(category);
    }

    @Override
    public Category disabledCategory(Category category) {
        return categoryDao.disabledCategory(category);
    }

    @Override
    public Category findIdcategory(String idcategory) {
        return categoryDao.findIdcategory(idcategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
