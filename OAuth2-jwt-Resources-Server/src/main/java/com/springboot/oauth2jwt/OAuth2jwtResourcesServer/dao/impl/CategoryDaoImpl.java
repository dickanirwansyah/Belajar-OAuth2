package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao.impl;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao.CategoryDao;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Category;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        if(category.getIdcategory() == null){
            category.setDisabled(true);
            categoryRepository.save(category);
        }else if(category.getIdcategory() != null){
            categoryRepository.save(category);
        }
        return category;
    }

    @Override
    public Category disabledCategory(Category category) {
        if(category.getIdcategory()!=null){
            category.setDisabled(false);
            categoryRepository.save(category);
        }
        return category;
    }

    @Override
    public Category findIdcategory(String idcategory) {
        return categoryRepository.findOne(idcategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
