package com.dto;

import java.time.LocalDate;

public class Farmer {

	private int id;
	private String name;
	private String address;
	private double DebtAmount;
	private LocalDate sanctiondate;
	public Farmer(String name, String address, double debtAmount, LocalDate sanctiondate) {
		super();
		this.name = name;
		this.address = address;
		DebtAmount = debtAmount;
		this.sanctiondate = sanctiondate;
	}
	public Farmer(int id, String name, String address, double debtAmount, LocalDate sanctiondate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		DebtAmount = debtAmount;
		this.sanctiondate = sanctiondate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getDebtAmount() {
		return DebtAmount;
	}
	public void setDebtAmount(double debtAmount) {
		DebtAmount = debtAmount;
	}
	public LocalDate getSanctiondate() {
		return sanctiondate;
	}
	public void setSanctiondate(LocalDate sanctiondate) {
		this.sanctiondate = sanctiondate;
	}
	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", address=" + address + ", DebtAmount=" + DebtAmount
				+ ", sanctiondate=" + sanctiondate + "]";
	}
	
	
	
}
