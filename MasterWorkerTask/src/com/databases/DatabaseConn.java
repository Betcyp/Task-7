package com.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.business.Job;
import com.constants.StudentQueries;

public class DatabaseConn {
	public static void insert(Job j1){
		try {
			Connection connection=getConnection();
			PreparedStatement inserted=connection.prepareStatement("INSERT INTO marklists(name,maths,physics,chemistry,percentage) VALUES ('"+j1.getStudName()+"', '"+j1.getStudMark1()+"', '"+j1.getStudMark2()+"', '"+j1.getStudMark3()+"', '"+j1.calcPercentage()+"')");;
			inserted.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Insertion completed");
		}
	}
	
	public static void  createTable() {
		try {
			Connection connection=getConnection();
			PreparedStatement create=connection.prepareStatement("CREATE TABLE IF NOT EXISTS marklists(name varchar(225),maths int NOT NULL AUTO_INCREMENT,physics int NOT NULL,chemistry int NOT NULL ,percentage int NOT NULL ,PRIMARY KEY(maths),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
			create.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Function Completed");
		}
	}
	public static Connection getConnection(){
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/student";
			String username="root";
			String password="Betcypbabu1998*";
			Class.forName(driver);
			
			Connection connection=DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			return connection; 
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
