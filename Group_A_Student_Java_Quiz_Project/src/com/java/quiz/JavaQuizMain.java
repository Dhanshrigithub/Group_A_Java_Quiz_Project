package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class JavaQuizMain {

	
	static String welcome_name = "";
	public static void alignmen(String welcome_name)
	{
		System.out.println("\n\t\t\t ***** WELCOME IN JAVA RAPID QUIZ ***** \n\n");
	}
	
	public static void main(String[] args) {
		
		
		JavaQuizMain jq = new JavaQuizMain();
		alignmen(welcome_name);
		
	    Login login = new Login();
		login.role();
		
	}

}
