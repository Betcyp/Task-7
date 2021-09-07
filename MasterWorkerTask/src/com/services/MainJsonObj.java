package com.services;

import org.json.simple.JSONObject;


public class MainJsonObj {
	public static void main(String[] args)    {
		
		JsonObj obj=new JsonObj();
		JSONObject jsonObject=obj.object();
		obj.insertInToDbForJsonObject(jsonObject);
		
		
	}
}

