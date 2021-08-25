package com.business;

import com.interfacess.JobInterface;

public class Job implements JobInterface {

    String studName;
	float studMark1;
	float studMark2;
	float studMark3;
	
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
	public float getStudMark1() {
		return this.studMark1;
	}
	public float getStudMark2() {
		return this.studMark2;
	}
	public float getStudMark3() {
		return this.studMark3;
	}
	
	public float calc_percentage() {
		return (this.studMark1+this.studMark2+this.studMark3)/3;
		
	}
	
}