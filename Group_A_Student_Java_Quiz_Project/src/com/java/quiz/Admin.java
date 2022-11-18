package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class Admin {
static int admin_id=5;	
static Scanner sc;
public static void admin_registration()  
{	
	 
		System.out.println("\t\t\t\tAdmin Registration");
		System.out.println("\n*****************************************************************************************");
		System.out.println(" ");
		sc = new Scanner(System.in);
		System.out.println("Enter Your Name");
		String admin_name = sc.nextLine();
		
		System.out.println("Enter Your UserName");
		String admin_username=sc.nextLine();
		
		System.out.println("Enter Your PassWord");
		String admin_password=sc.nextLine();		
		
		System.out.println("Enter Your Email_Id");
		String email_id = sc.nextLine();
		
		System.out.println("Enter Your MobileNumber");
		String admin_mob=sc.nextLine();
		
		System.out.println("Enter Your Designation");
		String admin_designation = sc.nextLine();
		
		int regi_date = 0;
		int admin_DOB = 0;
		
		try {
				Login.dbConnection();		
				String sqlquery = "insert into admin(Admin_ID, Admin_Name, Admin_UserName, Admin_Pwd, Admin_Email, Admin_Mobile, Admin_Designation, Regi_Date, Admin_DOB) values (?,?,?,?,?,?,?,?,?);";
				PreparedStatement prepare = Login.con.prepareStatement(sqlquery);
			    admin_id++;
				prepare.setInt(1,admin_id);
				prepare.setString(2, admin_name);
				prepare.setString(3, admin_username);
				prepare.setString(4, admin_password);
				prepare.setString(5, email_id);
				prepare.setString(6, admin_mob);
				prepare.setString(7, admin_designation);	
				prepare.setInt(8, regi_date);
				prepare.setInt(9, admin_DOB);
		
				int rowsAffected = prepare.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("\n\t** Registration Process Is Successfully Completed **\n\n\tPlease login in with your Username and Password");
}

public static void admin_account(String login_name)
{
	 JavaQuizMain.alignmen(login_name);
	 System.out.print("\n\n1. List of scholors students \n2. Search Student\n\n\n\n\n\n");
	 System.out.println("Enter your choice :- ");
	 Scanner sc1 = new Scanner(System.in);
	 int ad_ch = sc1.nextInt();
	 if (ad_ch==1)
	     listScholars(); 
	 else
	     searchStudent(); 
	 
	 
}

public static void listScholars()
{
	try {
		Login.dbConnection();
		String sqlquery="select id, studentName, score, grade, wrong_ans, emailId from student order by score DESC";
		PreparedStatement pre=Login.con.prepareStatement(sqlquery);
		
		ResultSet rst=pre.executeQuery();
		
		System.out.println("\n\t\t\t\tBelow are the Details of Student Result from Database\n");
		System.out.println("\n*********************************************************************************************************************");
		System.out.println(" Id"+"\t        Student Name\t          Score\t        Grade\t         Wrong Answers\t                  Email Id\n\n");			
		while(rst.next())
        {
			
			System.out.printf("" + rst.getString(1)) ;
			System.out.printf("          " + rst.getString(2)); 
			System.out.printf("		   " + rst.getString(3)); 
			System.out.printf("\t          "  + rst.getString(4)); 
			System.out.printf("\t                "  + rst.getString(5)); 
			System.out.printf("\t                " + rst.getString(6));
						System.out.println();
			
			
	    }
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public static void searchStudent()
{
	System.out.print("\n\n1. By Name \n2. By Id\n\n\n\n\n\n");
	 System.out.println("Enter your choice :- ");
	 Scanner sc1 = new Scanner(System.in);
	 int search_ch = sc1.nextInt();
	 if (search_ch==1)    
	 {
		 try {
				Login.dbConnection();
				System.out.println("Please Enter Student Name to Check Result :- ");
				Scanner sc2 = new Scanner(System.in);
				String nm = sc2.nextLine();
				
				String sqlquery="select id, studentName, score, grade from student where studentName = '" + nm + "'";
				PreparedStatement pre=Login.con.prepareStatement(sqlquery);
				
				ResultSet rst=pre.executeQuery();
				
				System.out.println("\n\n\t\t\t\t\t ***** Student Marksheet *****\n");
				System.out.println("\n*******************************************************************************************************************************");
				System.out.println("\n\n Id"+"\t       Student Name\t         Score\t      grade\n\n");
				while(rst.next())
		        {
			
					System.out.printf(" " + rst.getString(1)) ;
					System.out.printf("          " + rst.getString(2)); 
					System.out.printf("		   " + rst.getString(3)); 
					System.out.printf("            "  + rst.getString(4)); 
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}
	 }
	 else if(search_ch==2)   
	     {               
		 try {
				Login.dbConnection();
				System.out.println("Please Enter Student ID to Check Result :- ");
				Scanner sc2 = new Scanner(System.in);
				int search_id = sc2.nextInt();
				 				
				String sqlquery="select id, studentName, score, grade from student where id = '" + search_id + "'";
				PreparedStatement pre=Login.con.prepareStatement(sqlquery);
				
				ResultSet rst=pre.executeQuery();
				
				System.out.println("\n\n\t\t\t\t\t ***** Student Marksheet *****\n");
				System.out.println("\n*******************************************************************************************************************************");
				System.out.println("\n\n Id"+"\t       Student Name\t         Score\t      grade\n\n");
				while(rst.next())
		        {
			
					System.out.printf(" " + rst.getString(1)) ;
					System.out.printf("          " + rst.getString(2)); 
					System.out.printf("		   " + rst.getString(3)); 
					System.out.printf("            "  + rst.getString(4)); 
			    }
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	     } 
}

}
