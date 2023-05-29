package com.masai.Bike2;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Bike {
	@Id
	private String id;
	private String brand;
	private String model;
	private double price;
	private LocalDate rdate;
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bike(String id, String brand, String model, double price, LocalDate rdate) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.rdate = rdate;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getRdate() {
		return rdate;
	}
	public void setRdate(LocalDate rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + ", rdate=" + rdate
				+ "]";
	}
}
