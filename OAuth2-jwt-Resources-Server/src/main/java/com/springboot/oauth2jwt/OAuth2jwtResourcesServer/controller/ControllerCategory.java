package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.controller;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Category;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/api/category")
    public ResponseEntity<List<Category>> findAll(){
        return Optional.ofNullable(categoryService.findAll())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/api/category/create")
    public ResponseEntity<Category> created(@RequestBody Category category){
        return Optional.ofNullable(categoryService.createCategory(category))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }
}
