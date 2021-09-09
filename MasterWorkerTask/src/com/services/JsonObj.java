package com.services;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

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

	
}