package com.business;

import com.interfacess.JobInterface;

public class Job implements JobInterface {

    String studName;
	String sub;
	int studMark;
	
	public void setStudName(String name) {
		this.studName=name;
	}
	public void setSub(String sub) {
		this.sub=sub;
	}
	public void setStudMark(int num) {
		this.studMark= num;
	}
	public String getStudName() {
		return this.studName;
	}
	public String getSub() {
		return this.sub;
	}
	public int getStudMark() {
		return this.studMark;
	}
	
	public int square() {
		return this.studMark*this.studMark;
	}
	public int cube() {
		return this.studMark*this.studMark*this.studMark;
	}
}