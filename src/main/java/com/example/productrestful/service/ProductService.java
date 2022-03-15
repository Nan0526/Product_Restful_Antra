package com.example.productrestful.service;

import java.util.Map;

import com.example.productrestful.model.Product;


public interface ProductService {
    
    Map<Long, Product> getAll();
    Product create(Product product);
    void delete(Long id);
    Product update(Long id, Product product);
    Product getProduct(Long Id);
}
