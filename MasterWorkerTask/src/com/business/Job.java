package com.business;

import com.interfacess.JobInterface;

public class Job implements JobInterface {

    String studName;
	int studMark1;
	int studMark2;
	int studMark3;
	double total;
	double per;
	
	public void setStudName(String name) {
		this.studName=name;
	}
	public void setStudMark1(int maths) {
		this.studMark1=maths;
	}	
	public void setStudMark2(int physics) {	
		this.studMark2=physics;
	}
	public void setStudMark3(int chemistry) {	
		this.studMark3=chemistry;
	}
	public String getStudName() {
		return this.studName;
	}
	public int getStudMark1() {
		return this.studMark1;
	}
	public int getStudMark2() {
		return this.studMark2;
	}
	public int getStudMark3() {
		return this.studMark3;
	}
	
	public double calcPercentage() {
		total=this.studMark1+this.studMark2+this.studMark3;
		per=(total/300.0)*100;
		return Math.round(per);
	}
	
}