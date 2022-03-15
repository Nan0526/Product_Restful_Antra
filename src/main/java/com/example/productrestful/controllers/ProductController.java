package com.example.productrestful.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.productrestful.model.Product;
import com.example.productrestful.service.ProductService;




@RestController
@RequestMapping("/rest_products")
public class ProductController {
	
    @Autowired
    ProductService productService;
    
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class); 
    
    
    
    
    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody @Validated Product product) {
        logger.info("Create {}", product.getName());
        productService.create(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/product/{id}")
    public ResponseEntity<Map <Long, Product>> update(@PathVariable Long id,
                                                             @RequestBody @Validated Product product) {
        if (!valid(id)) {
            return ResponseEntity.notFound().build();
        }
        productService.update(id, product);
        logger.info("Update id  {}", id);
        return new ResponseEntity<>(productService.getAll(), HttpStatus.ACCEPTED);
    }

    
    @GetMapping("/products")
    public ResponseEntity<Map<Long, Product>> getAll() {
        Map<Long, Product> allProducts = productService.getAll();
        logger.info("Getting " + allProducts.size() + " products");
        return new ResponseEntity<Map<Long, Product>>(allProducts, HttpStatus.OK);
    }
    
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        if (!valid(id)) {
            return ResponseEntity.notFound().build();
        }
        logger.info("Get product {}", id);
        return new ResponseEntity<Product>(productService.getProduct(id), HttpStatus.OK);
    }
    


    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        if (!valid(id)) {
            return ResponseEntity.notFound().build();
        }
        logger.info("Successfully delete product id {}", id);
        productService.delete(id);
        return ResponseEntity.accepted().build();
    }
    
    
    public boolean valid(Long id) {
        if (productService.getProduct(id) == null) {
            logger.error("No such product");
            return false;
        } else {
            return true;
        }
    }
}

