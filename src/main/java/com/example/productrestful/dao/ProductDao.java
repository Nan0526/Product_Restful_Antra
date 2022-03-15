package com.example.productrestful.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.productrestful.model.Product;

@Repository
public class ProductDao {
	
	Map<Long, Product> map = new HashMap<>();
	
	public ProductDao() {
		getData();
	}

	public Map<Long, Product> getMap() {
		return map;
	}

	public void setMap(Map<Long, Product> map) {
		this.map = map;
	}
	
	public void getData() {
		map.put(0L, new Product("bread", 20, 10));
		map.put(1L, new Product("fruit", 40, 20));
		map.put(2L, new Product("food", 20, 30));
		map.put(3L, new Product( "drink", 60, 40));
		map.put(4L, new Product( "milk", 40, 50));
        map.put(5L, new Product( "juice", 10, 60));
	}

}
