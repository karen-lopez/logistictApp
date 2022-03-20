package com.kl.logisticts.apirest.services.product;

import com.kl.logisticts.apirest.entitys.Product;
import java.util.List;


public interface IProductService {
    List<Product> findAll();
    Product findById(String id);
    Product save(Product product);
}
