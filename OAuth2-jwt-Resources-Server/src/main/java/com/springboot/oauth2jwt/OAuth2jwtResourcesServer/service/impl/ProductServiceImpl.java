package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service.impl;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao.ProductDao;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Product;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ProductServiceImpl(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getIdproduct() == null){
            product.setImage("poto"+ UUID.randomUUID().toString().substring(25));
            product.setDisabled(true);
            productDao.createProduct(product);
        }else if(entityManager.contains(product)){
            product = entityManager.merge(product);
            return product;
        }
        return product;
    }

    @Override
    public Product findIdproduct(String idproduct) {
        return productDao.findId(idproduct);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product disabled(Product product) {
        if(product.getIdproduct() != null){
            product.setDisabled(false);
            productDao.disabledProduct(product);
        }
        return product;
    }
}
