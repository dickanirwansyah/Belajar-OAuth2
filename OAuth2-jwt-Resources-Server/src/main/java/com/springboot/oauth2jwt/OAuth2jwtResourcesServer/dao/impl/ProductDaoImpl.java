package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao.impl;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.dao.ProductDao;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Product;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{

    private final ProductRepository productRepository;

    @Autowired
    public ProductDaoImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        if(product.getIdproduct() == null){
            product.setDisabled(true);
            productRepository.save(product);
        }else if(product.getIdproduct() != null){
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product disabledProduct(Product product) {
        if(product.getIdproduct() != null){
            productRepository.save(product);
        }

        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findId(String idproduct) {
        return productRepository.findOne(idproduct);
    }
}
