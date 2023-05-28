package com.masai.Garments;

import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App 
{
	static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("Raushan");
	}
	
    public static void main( String[] args )
    {
       Scanner sc=new Scanner(System.in);
       int c;
       
       do {
    	   
    	   System.out.println("1. Add");
    	   System.out.println("2. Update");
    	   
    	   System.out.println("3. Delete");
    	   System.out.println("4. Find");
    	   System.out.println("0. Exit");
    	   
    	   c=sc.nextInt();
    	   switch(c){
    	   case 1:
    		   Add(sc);
    		   break;
    	   case 2:
    		   Update(sc);
    		   break;
    	   case 3:
    		   Delete(sc);
    		   break;
    		   
    	   case 4:
    		  Find(sc);
    		   break;
    	   case 0:
    		   System.out.println("Thanks");
    		   break;
    		   
    	   }
    	   
       }while(c!=0);
       sc.close();
    }

	private static void Add(Scanner sc) {
		
		System.out.println("Enter product name");
		String pname=sc.next();
		System.out.println("Enter product type");
		String ptype=sc.next();
		System.out.println("Enter product price");
		double price=sc.nextDouble();
		
		System.out.println("Enter product Brand");
		String pbrand=sc.next();
		
		Clothes a=new Clothes(pname,ptype,price,pbrand);
		
		AddPrompt(a);
		
	}

	private static void AddPrompt(Clothes a) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(a);
		et.commit();
		em.close();
		
	}

	private static void Update(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter product name");
		String pname=sc.next();
		System.out.println("Enter product type");
		String ptype=sc.next();
		System.out.println("Enter product price");
		double price=sc.nextDouble();
		
		System.out.println("Enter product Brand");
		String pbrand=sc.next();
		
		Clothes a=new Clothes(id,pname,ptype,price,pbrand);
		
		UpdatePrompt(id,a);
		
	}

	private static void UpdatePrompt(int id,Clothes a) {
		EntityManager em=emf.createEntityManager();
		
		Clothes t=em.find(Clothes.class, id);
		
		if(t==null) {
			System.out.println("id not found");
		}else {
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(a);
		et.commit();
		em.close();
		}
		
	}

	private static void Delete(Scanner sc) {
		
		System.out.println("Enter id");
		int id=sc.nextInt();
		DeletePrompt(id);
	}

	private static void DeletePrompt(int id) {
EntityManager em=emf.createEntityManager();
		
		Clothes t=em.find(Clothes.class, id);
		
		if(t==null) {
			System.out.println("id not found");
		}else {
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.remove(t);
		et.commit();
		em.close();
		}
		
		
	}

	private static void Find(Scanner sc) {

		System.out.println("Enter id");
		int id=sc.nextInt();
		FindPrompt(id);
		
	}

	private static void FindPrompt(int id) {
EntityManager em=emf.createEntityManager();
		
		Clothes t=em.find(Clothes.class, id);
		
		if(t==null) {
			System.out.println("id not found");
		}else {
		 System.out.println("id: "+ t.getId() +" pname: "+t.getProduct_name()+ " ptype: "+t.getProduct_type() + " price: "+t.getPrice() +" barnd: "+t.getBrand());
		}
		
	}
}
