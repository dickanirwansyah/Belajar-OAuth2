package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.controller;

import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity.Product;
import com.springboot.oauth2jwt.OAuth2jwtResourcesServer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerProduct {

    private final ProductService productService;

    @Autowired
    public ControllerProduct(ProductService productService){
        this.productService = productService;
    }

    //list product
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/api/product")
    public ResponseEntity<List<Product>> getAll(){
        return Optional.ofNullable(productService.findAll())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST));
    }

    //upload image and handling saved
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/api/product/create")
    public @ResponseBody void uploads(@RequestParam("file")MultipartFile file,
                                      Product product){

        createProduct(product);
        String originalNameImage = "";
        try{
            byte[] bytes = file.getBytes();
            originalNameImage = product.getImage()+".jpg";


            BufferedOutputStream stream =
                    new BufferedOutputStream
                            (new FileOutputStream(new File("//var//www//html//server-poto//"+originalNameImage)));
            stream.write(bytes);
            stream.close();
            System.out.println("Upload Successfully "+originalNameImage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //create and saved product
    private Product createProduct(Product product){
        return productService.createProduct(product);
    }
}
