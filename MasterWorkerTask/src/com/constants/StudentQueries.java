package com.constants;
public class StudentQueries {
	
	public static final String INSERT_QUERY="INSERT INTO MARKLIST(name,maths,physics,chemistry,percentage) VALUES (?, ?, ?, ?, ?)";
	
	public static final String INSERT_QUERYJSON="INSERT INTO MARKS(name,maths,physics,chemistry,percentage) VALUES (?, ?, ?, ?, ?)";
	
	public static final String RETRIEVE_QUERYJSON="SELECT * FROM MARKS";
}