package com.services;

import org.json.simple.JSONObject;

import com.databases.InsertDatabase;

public class MainJsonObj {
	public static void main(String[] args) {
		
		JsonObj obj=new JsonObj();
		JSONObject jsonObject=obj.object();
		String file1=args[0];
		obj.insertInToDbForJsonObject(jsonObject,file1);
		
		
	}
}

