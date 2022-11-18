package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	static Connection con;
	static Statement stmt;
	static ResultSet  rs;
	static int stu_id=0, admin_id = 0;
	public static void dbConnection()  
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb?characterEncoding=utf8", "root", "root");	// use database named as javaquizdb in your code		
			stmt = con.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public int role()  
	{ 
		
		System.out.println("1. Student\n2. Admin\n\n");
		System.out.println("\nPlease Enter who are you :-  ");
		Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
       
		System.out.println("\n\n1. Already Registered \n2. New\n\n");
		System.out.println("\nPlease Enter your choice :-  ");
		sc = new Scanner(System.in);
		
		int ch_state = sc.nextInt();
		
		if (choice==1 && ch_state==1)   
			direct_login(choice);
		else if(choice==1 && ch_state==2) 
		{
			Student.student_registration(); 
			direct_login(choice);    
		}
		
		
		if (choice==2 && ch_state==1)   
			direct_login(choice);
		else if(choice==2 && ch_state==2)  
		{
			Admin.admin_registration(); 
			direct_login(choice);     
		}
		
		return choice;
		
	}
	
	public void direct_login(int ch) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease Enter your Username :- ");		
		String login_name = sc.nextLine();
		System.out.println("\nPlease Enter your Password :- ");
		String pwd = sc.nextLine();	
		try
		{ 
		   dbConnection();
		 
		 if (ch==1) {
		 rs = stmt.executeQuery("select id, username, password from student"); 
		 
		 while (rs.next())
		 {   
			 
			 if(login_name.equalsIgnoreCase(rs.getString(2)) && pwd.equals(rs.getString(3)));
			 {
			       System.out.println("\n\tYou have logged in successfully!!!\n\n"); 
			       stu_id = rs.getInt(1);
			       
			       
			       System.out.println("\n\n\t ***** Quiz Rules *****");
					System.out.println("\n\n\t 1. You need to solve all questions compulsory. ");
					System.out.println("\n\t 2. One question has four options only.");
					System.out.println("\n\t 3. Each question having 2 marks.");
					System.out.println("\n\t 4. No negative marking");
					System.out.println("\n\t 5. Quiz time 15 Min.");
					
					System.out.println("\n\n\n\t ***** Best of Luck!!! *****");
					
					System.out.println("\n\n\t Do you want to start the test.Please enter (Y/N/E) ");
					System.out.println("\n\t 1.YES");
					System.out.println("\t 2.No");
					System.out.println("\t 3.EXIT");


					String opt = sc.nextLine();
				
					switch(opt)
					{
					
					case "Y": 
						System.out.println("\n\n\tLets Starts The Quiz...\n\n\n");
						break;
						
					case "N":
						System.out.println("\n\tTest close");
						break;
						
					case "E":
						System.out.println("\n\tThank You!!!");
						break;
					
					}	
					
			 }
			
			 break;
		 }
		 
		
		 Student.student_account(login_name);  
		 }
		 else 
		 {
             rs = stmt.executeQuery("select Admin_ID, Admin_UserName, Admin_Pwd from admin");
             while (rs.next())
    		 {       			 
            	 if(login_name.equalsIgnoreCase(rs.getString(2)) && pwd.equals(rs.getString(3)));
            	 {
			        System.out.println("\n\tYou have logged in successfully!!!\n\n"); 
				    admin_id = rs.getInt(1);
            	 } 
            	 break;
    		 } 
             Admin.admin_account(login_name); 
		 }
		 
		 
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	
	
	
}
