package com.example.productrestful.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productrestful.dao.ProductDao;
import com.example.productrestful.model.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
    @Autowired
    ProductDao productDao;

	@Override
	public Map<Long, Product> getAll() {
		return productDao.getMap();
	}

	@Override
	public Product create(Product product) {
		Long id = Collections.max(productDao.getMap().keySet()) + 1;
		productDao.getMap().put(id, product);
		return product;
	}

	@Override
	public void delete(Long id) {
		productDao.getMap().remove(id);
	}

	@Override
	public Product update(Long id, Product product) {
		 productDao.getMap().put(id, product);
	     return product;
	}

	@Override
	public Product getProduct(Long id) {
		return productDao.getMap().get(id);
	}
}
