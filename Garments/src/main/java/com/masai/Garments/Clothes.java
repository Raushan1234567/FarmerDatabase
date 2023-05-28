package com.masai.Garments;

import jakarta.persistence.*;

@Entity
public class Clothes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String product_name;
	private String product_type;
	private double price;
	private String brand;
	public Clothes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clothes(String product_name, String product_type, double price, String brand) {
		super();
		
		this.product_name = product_name;
		this.product_type = product_type;
		this.price = price;
		this.brand = brand;
	}
	
	
	public Clothes(int id, String product_name, String product_type, double price, String brand) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_type = product_type;
		this.price = price;
		this.brand = brand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Clothes [id=" + id + ", product_name=" + product_name + ", product_type=" + product_type + ", price="
				+ price + ", brand=" + brand + "]";
	}
	
	
	
	
	
	
	
	
}
