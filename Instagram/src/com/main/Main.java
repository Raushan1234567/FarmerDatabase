package com.main;
import java.time.LocalDate;
import java.util.*;
import com.dao.*;
import com.dto.*;
import com.exception.NOrecordFound;
import com.exception.SomeThingWentWrong;


public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int c;
		
		do {
			System.out.println("1. Add");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Find");
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
				Dlete(sc);
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
			}
		}while(c!=0);
		sc.close();
	}

	private static void Add(Scanner sc) {
		
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter Follwer");
		int follower=sc.nextInt();
		System.out.println("Enter Following");
		int following=sc.nextInt();
		System.out.println("Enter Join date");
		LocalDate joindate=LocalDate.parse(sc.next());
		
		Instagram a=new Instagram(following, follower, name,joindate);
		
		Inter b=new ServiceImple();
		
		try {
			b.AdddPrompt(a);
			System.out.println("Success");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	private static void Update(Scanner sc) {
		
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter userid");
		String name=sc.next();
		
		
		
Inter b=new ServiceImple();
		
		try {
			b.UpdatePrompt(id,name);
			System.out.println("Success");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	private static void Dlete(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
Inter b=new ServiceImple();
		
		try {
			b.DeletePrompt(id);
			System.out.println("Success");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	private static void Find(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
Inter b=new ServiceImple();
		
		try {
	Instagram z=b.FindPrompt(id);
			System.out.println(z);
		} catch (SomeThingWentWrong | NOrecordFound e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	private static void Print(Scanner sc) {
Inter b=new ServiceImple();
		
		try {
	List<Instagram> z=b.PrintPrompt();
			z.forEach(System.out::println);
		} catch (SomeThingWentWrong | NOrecordFound e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
}
