package com.masai.Mapping1;

import jakarta.persistence.*;

import java.util.*;
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private int ESTDYear;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Mobile> mobiles = new ArrayList<>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(String companyName, int eSTDYear, List<Mobile> mobiles) {
		super();
		
		this.companyName = companyName;
		ESTDYear = eSTDYear;
		this.mobiles = mobiles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getESTDYear() {
		return ESTDYear;
	}

	public void setESTDYear(int eSTDYear) {
		ESTDYear = eSTDYear;
	}

	public List<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", ESTDYear=" + ESTDYear + ", mobiles=" + mobiles
				+ "]";
	}
    
	
    
    
    
}