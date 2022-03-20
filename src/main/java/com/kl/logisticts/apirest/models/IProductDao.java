package com.kl.logisticts.apirest.models;

import com.kl.logisticts.apirest.entitys.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IProductDao extends MongoRepository<Product, String>{
    
}
