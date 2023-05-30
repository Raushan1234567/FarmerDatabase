package com.masai.Mapping1;

import jakarta.persistence.*;



@Entity
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelNumber;
    private double price;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(String modelNumber, double price, Company company) {
		super();
		this.modelNumber = modelNumber;
		this.price = price;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", modelNumber=" + modelNumber + ", price=" + price + ", company=" + company + "]";
	}
    
    
    
}



