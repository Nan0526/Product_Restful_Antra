package com.example.productrestful.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
	
    @NotNull
    @Size(max = 200)
	private String name;
	
    @NotNull
    @Min(5)
    @Max(500)
	private int totalPrice;
    
    @NotNull
    @Min(1)
    @Max(100)
	private int quantity;
	
	
	
	public Product(String name, int totalPrice, int quantity) {
		super();
		this.name = name;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return totalPrice;
	}
	public void setPrice(int price) {
		this.totalPrice = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
}
