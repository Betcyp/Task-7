package com.services;

import org.json.simple.JSONObject;

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
	public void insertInToDbForJsonObject(JSONObject jsonObject) {
		String studName=(String)jsonObject.get("Name");
		int studMark1=(int)jsonObject.get("Maths");
		int studMark2=(int)jsonObject.get("Physics");
		int studMark3=(int)jsonObject.get("Chemistry");
		
		System.out.println("Name: "+studName+" Maths: "+studMark1+ " Physics: "+studMark2+ " Chemistry: "+studMark3+ " Percentage: "+calcPercentage(studMark1, studMark2, studMark3));   
		
	}

	public double calcPercentage(int studMark1,int studMark2,int studMark3) {
		total=studMark1+studMark2+studMark3;
		per=(total/300.0)*100;
		return Math.round(per);
	}
}