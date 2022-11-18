package com.java.quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Student {

	static int stu_id=0;
 	static String grade="";
 	static int wrong_ans=0;
	 	
	public static void student_registration()
	{
		 		
		 		System.out.println("\t\t\t\t ****** Student Registration ******");
		 		System.out.println(" ");
		 		Scanner sc = new Scanner(System.in);
		 		
		 		System.out.println("Enter Your Id :- ");
		 		String id = sc.nextLine();
		 		
		 		System.out.println("Enter Your Name :- ");
		 		String studentname = sc.nextLine();
		 		
		 		System.out.println("Enter Your UserName :- ");
		 		String username=sc.nextLine();
		 		
		 		System.out.println("Enter Your PassWord :- ");
		 		String password=sc.nextLine();
		 		
		 		System.out.println("Enter Your Mobile Number :-");
		 		long mobilenum=sc.nextLong();
		 		
		 		System.out.println("Enter Your Email_Id :- ");
		 		String emailid = sc.next();
		 		
		 		int score=0;
		 		
		 		try {
		 				Login.dbConnection();

		 				String sqlquery = "insert into student(studentname,username,password,mobilenum,emailid,score,grade,id,wrong_ans) values (?,?,?,?,?,?,?,?,?);";
		 				PreparedStatement prepare = Login.con.prepareStatement(sqlquery);
		 				stu_id++;
		 		
		 				prepare.setString(1,studentname);
		 				prepare.setString(2,username);
		 				prepare.setString(3,password);
		 				prepare.setLong(4,mobilenum);
		 				prepare.setString(5,emailid);
		 				prepare.setInt(6, score);
		 				prepare.setString(7,grade);	
		 				prepare.setInt(8, stu_id);
		 				prepare.setInt(9, wrong_ans);
		 		
		 				int rowsAffected = prepare.executeUpdate();
		 			}
		 			catch(Exception e)
		 			{
		 				e.printStackTrace();
		 			}
		 		System.out.println("\n\n\t\t********** Your Registration Successfully Completed!!! **********");
		 		System.out.println("\n\n\n\t\t\t***** Now Login with your Credentials *****");
		 		System.out.println();
		 		System.out.println();
	}

	
	public static void student_account(String login_name)
	{
    	 JavaQuizMain.alignmen(login_name);
		 
		 start_quiz(login_name);  
		 
    }
	
	public static void start_quiz(String login_name)
	{
		int score = 0, wrong_ans = 0;
		String grade = "";
		try
		{
			Login.dbConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
        Random ran = new Random();
		try 
		{
			int i = 1;
			
			do
			{
//				int x = ran.nextInt(2) + 3;
				
				int x = ran.nextInt(10) + 1;
				
						
				Login.rs = Login.stmt.executeQuery("select java_question, optionA, optionB, optionC, option_yes from javaquiz where id=" +x); // if ch is 1(student)
				Login.rs.next();
				System.out.println(i + ". " + Login.rs.getString(1) );
				System.out.println("   a. " + Login.rs.getString(2) + "\n" + "   b. " + Login.rs.getString(3) + "\n" + "   c. " + Login.rs.getString(4) + "\n" + "   d. " + Login.rs.getString(5) + "\n\n\n");
				
				System.out.println("Enter your option : ");
				Scanner sc = new Scanner(System.in);
				char option = sc.nextLine().charAt(0);
				System.out.println("\n");
				if (option=='d')
					score++;
				else
					wrong_ans++;
				i++;
			} while (i<=10);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		JavaQuizMain.alignmen(login_name);
		System.out.println("\n\n");
		if(score==8 || score==9 || score==10)
		{
			System.out.println("\n\t Congratulations!!!\n");
			grade = "A";
		}
		else if(score==6 || score==7 || score==8 ) { grade="B"; System.out.println("Good Attempt But Try More...!!!\n");}
		else if(score==5) { grade="c"; System.out.println("Need To Read Every Concept In Depth...!!!\n");}
		else { grade="Fail"; System.out.println("You Must Work Hard...!!!\n");}
		   
		System.out.println("\n\tName :- "+login_name );
		System.out.println("\n\tYour score is :- " + score); 
		System.out.println("\n\tWrong answers :- " + wrong_ans);
		System.out.println("\n\tYou have Secured Grade :- " + grade);
		
		System.out.println("\n\n\n\n\n\n");
		try 
		{
			String updateQuery = "update student set score = ?, grade = ?, wrong_ans = ? where username = '" + login_name + "'";
			PreparedStatement preparedStmt = Login.con.prepareStatement(updateQuery);
			preparedStmt.setInt   (1, score);
			preparedStmt.setString(2, grade);
			preparedStmt.setInt(3, wrong_ans);

	        preparedStmt.executeUpdate();	      
	        Login.con.close();
		}
		catch(SQLException e) {e.printStackTrace();}
	}
}
