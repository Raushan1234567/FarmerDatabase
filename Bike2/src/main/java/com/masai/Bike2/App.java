package com.masai.Bike2;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;

import jakarta.persistence.Persistence;
public class App {
	
	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("Raushan");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c;
		do {
			System.out.println("1. Add");
			System.out.println("2. View");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			
			System.out.println("0. Exit");
			
			c=sc.nextInt();
			switch(c) {
			case 1:
				Add(sc);
				break;
			case 2:
				View(sc);
				break;
			case 3:
				Update(sc);
				break;
			case 4:
				Delete(sc);
				break;
			case 0:
				System.out.println("Thanks");
				break;
				default :
					System.out.println("Invalid");
					break;
				
			}
		}while(c!=0);
		sc.close();
		
	}

	private static void Add(Scanner sc) {
		
		System.out.println("Enter id");
		String id=sc.next();
		System.out.println("Enter brand");
		String brand=sc.next();
		System.out.println("Enter model");
		String model=sc.next();
		System.out.println("Enter price");
		double price=sc.nextDouble();
		System.out.println("Enter registration date");
		LocalDate rdate=LocalDate.parse(sc.next());
		
		Bike a=new Bike(id,brand,model,price,rdate);
		
		AddUI(a);
		
		
	}

	private static void AddUI(Bike a) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(a);
		et.commit();
		em.clear();
		
		
		
	}

	private static void View(Scanner sc) {
		System.out.println("Enter id");
		String id=sc.next();
		
		Print(id);
		
		
	}

	private static void Print(String id) {
		EntityManager em=emf.createEntityManager();
		
		Bike t=em.find(Bike.class,id );
		if(t==null) {
			System.out.println("This id is not available");
		}
		else{
			System.out.println("id: "+t.getId() +" brand: "+t.getBrand() +" model "+t.getModel() +" price: "+t.getPrice() +" radte: "+t.getRdate());
		}
		
	}

	private static void Update(Scanner sc) {
		System.out.println("Enter id");
		String id=sc.next();
		System.out.println("Enter brand");
		String brand=sc.next();
		System.out.println("Enter model");
		String model=sc.next();
		
		Update(id,brand,model);
		
		
	}

	private static void Update(String id, String brand, String model) {
		
	EntityManager em=emf.createEntityManager();
		
		Bike t=em.find(Bike.class,id );
		if(t==null) {
			System.out.println("This id is not available");
		}else {
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			t.setBrand(brand);
			t.setModel(model);
			et.commit();
		}
		em.close();
		
		
	}

	private static void Delete(Scanner sc) {
		System.out.println("Enter id");
		String id=sc.next();
		
EntityManager em=emf.createEntityManager();
		
		Bike t=em.find(Bike.class,id );
		if(t==null) {
			System.out.println("This id is not available");
		}else {
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.remove(t);
			System.out.println("Dleted successfully");
			et.commit();
		}
		em.close();

		
	}

}
