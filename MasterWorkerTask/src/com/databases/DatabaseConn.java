package com.databases;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import com.business.Job;
import com.constants.StudentQueries;
import com.queuess.ReadCsvFile;

public class DatabaseConn {
	
	
	public static void insert(Job j1,String file1){
		try {
			Connection connection=getConnection(file1);
			PreparedStatement inserted=connection.prepareStatement(StudentQueries.INSERT_QUERY);
			{
				inserted.setString(1, j1.getStudName());
				inserted.setDouble(2, j1.getStudMark1());
				inserted.setDouble(3, j1.getStudMark2());
				inserted.setDouble(4, j1.getStudMark3());
				inserted.setDouble(5, j1.calcPercentage());
			}
			inserted.executeUpdate();
			connection.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void createTable(String file1) {
		try {
			Connection connection=getConnection(file1);
			PreparedStatement create=connection.prepareStatement("CREATE TABLE IF NOT EXISTS MARKLIST(name varchar(225),maths int NOT NULL AUTO_INCREMENT,physics int NOT NULL,chemistry int NOT NULL ,percentage int NOT NULL ,PRIMARY KEY(maths),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
			create.executeUpdate();
			connection.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static Connection getConnection(String file1){
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream("Config.properties"));
		
			String theUsername=prop.getProperty("username");
			String thePassword=prop.getProperty("password");
			String theDburl=prop.getProperty("url");
			
			Connection connection=DriverManager.getConnection(theDburl, theUsername, thePassword);
			System.out.println("connected");
			return connection;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void insertDataInToDatabase(ReadCsvFile csv,String file1) throws InterruptedException {
			while(csv.isQueueEmpty()==false) {
				Job j1=csv.fetch();
				insert(j1,file1);
		
			}
	}

}
