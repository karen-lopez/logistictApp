package com.kl.logisticts.apirest.controllers;

import com.kl.logisticts.apirest.services.product.IProductService;
import com.kl.logisticts.apirest.entitys.Product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    IProductService productService;
    
    @GetMapping("/products")
    public List<Product> list(){
        return productService.findAll();
    }
    
    @PostMapping("/products")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    
    @GetMapping("/product/{id}")
    public Product findById(@PathVariable String id){
        return productService.findById(id);
    }
}
