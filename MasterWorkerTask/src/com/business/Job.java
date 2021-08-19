package com.business;

import com.interfacess.JobInterface;

public class Job implements JobInterface {

	int num;
	public Job(int num) {
		this.num=num;
	}
	public int square() {
		return this.num*this.num;
		
	}
}