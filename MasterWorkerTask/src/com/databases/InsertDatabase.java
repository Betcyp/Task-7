package com.databases;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import org.json.simple.JSONObject;

import com.constants.StudentQueries;

public class InsertDatabase {
	
	@SuppressWarnings("unchecked")
	public static ResultSet frameResponse(String file1)  {
		try {
			Connection connection=getConnection(file1);
			PreparedStatement ps=connection.prepareStatement(StudentQueries.RETRIEVE_QUERYJSON);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("name",rs.getString("name"));
				jsonObject.put("maths",rs.getInt("maths"));
				jsonObject.put("physics",rs.getInt("physics"));
				jsonObject.put("chemistry",rs.getInt("chemistry"));
				jsonObject.put("percentage",rs.getInt("percentage"));
				System.out.println(jsonObject);
			}
			connection.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void insertInToDbForJsonObject(JSONObject jsonObject,String file1){
		try {
			Connection connection=getConnection(file1);
			String studName=(String)jsonObject.get("Name");
			int studMark1=(int)jsonObject.get("Maths");
			int studMark2=(int)jsonObject.get("Physics");
			int studMark3=(int)jsonObject.get("Chemistry");
			double studPercentage=calcPercentage(studMark1, studMark2, studMark3);
			PreparedStatement inserted=connection.prepareStatement(StudentQueries.INSERT_QUERYJSON);
			{
				inserted.setString(1,studName);
				inserted.setInt(2, studMark1);
				inserted.setInt(3, studMark2);
				inserted.setInt(4, studMark3);
				inserted.setDouble(5, calcPercentage(studMark3, studMark3, studMark3));
			}
			inserted.executeUpdate();
			System.out.println("inserted");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public double calcPercentage(int studMark1, int studMark2, int studMark3) {
		double total=studMark1+studMark2+studMark3;
		double per=(total/300.0)*100;
		return Math.round(per);
	}

	public static void createTable(String file1) {
		try {
			Connection connection=getConnection(file1);
			PreparedStatement create=connection.prepareStatement("CREATE TABLE IF NOT EXISTS MARKLIST(name varchar(225),maths int NOT NULL AUTO_INCREMENT,physics int NOT NULL,chemistry int NOT NULL ,percentage int NOT NULL ,PRIMARY KEY(maths),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
			create.executeUpdate();
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
}
