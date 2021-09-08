package com.services;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.databases.InsertDatabase;

public class JsonObj {
	
	double total;
	double per;
	@SuppressWarnings("unchecked")
	public JSONObject object() {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Name","Anu");
		jsonObject.put("Maths",88);
		jsonObject.put("Physics",85);
		jsonObject.put("Chemistry",87);
		
		System.out.println(jsonObject);
		return jsonObject;
	}
	public void insertInToDbForJsonObject(JSONObject jsonObject,String file1) {
		String studName=(String)jsonObject.get("Name");
		int studMark1=(int)jsonObject.get("Maths");
		int studMark2=(int)jsonObject.get("Physics");
		int studMark3=(int)jsonObject.get("Chemistry");
		double studPercentage=calcPercentage(studMark1, studMark2, studMark3);
		
		System.out.println("Values are: "+studName+" "+studMark1+ " "+studMark2+ " "+studMark3+ " "+studPercentage);   
		InsertDatabase id=new InsertDatabase();
		id.getConnection(file1);
		id.insertInToDb(jsonObject,file1);
	}
	

	public double calcPercentage(int studMark1,int studMark2,int studMark3) {
		total=studMark1+studMark2+studMark3;
		per=(total/300.0)*100;
		return Math.round(per);
	}
}