package com.main;
import java.time.LocalDate;
import java.util.*;
import com.dao.*;
import com.dto.*;
import com.exception.NorecorsFounf;
import com.exception.SomethingWentWrong;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int c;
		do {
			System.out.println("1. Add");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Find BI id");
			System.out.println("5. Print");
			System.out.println("0. Exit");
			
			c=sc.nextInt();
			switch(c) {
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
			case 5:
				Print(sc);
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
		
		
		
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter address");
		String address=sc.next();
		System.out.println("Enter debt amount");
	  double debt=sc.nextDouble();
	  System.out.println("Enter date of Sanction loan amount");
	  LocalDate sd=LocalDate.parse(sc.next());
	  
	  Farmer a=new Farmer(name, address, debt, sd);
	  
	  Inter b=new Servicemple();
	  
	  try {
		b.AddUi(a);
		System.out.println("Success");
	} catch (SomethingWentWrong e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	  
		
	}

	private static void Update(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter address");
		String address=sc.next();
		System.out.println("Enter debt amount");
	  double debt=sc.nextDouble();
	  System.out.println("Enter date of Sanction loan amount");
	  LocalDate sd=LocalDate.parse(sc.next());
	  
	  Farmer a=new Farmer(id, name, address, debt, sd);
	  
	  Inter b=new Servicemple();
	  
	
 
	  
	  try {
		  b.UpdateUi(a);
		System.out.println("Success");
	} catch (SomethingWentWrong e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	  
		
	}

	private static void Delete(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		 Inter b=new Servicemple();
		  
			
		 
		  
		  try {
			  b.DeleteUi(id);
			System.out.println("Success");
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		  
	}

	private static void Find(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		 Inter b=new Servicemple();
		  
			
		 
		  
		  try {
			 Farmer f= b.FindUi(id);
			System.out.println(f);
		} catch (SomethingWentWrong | NorecorsFounf e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	private static void Print(Scanner sc) {
		 Inter b=new Servicemple();
		  
			
		 
		  
		  try {
			List<Farmer> list= b.PrintUi();
		list.forEach(System.out::println);
		} catch (SomethingWentWrong | NorecorsFounf e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
