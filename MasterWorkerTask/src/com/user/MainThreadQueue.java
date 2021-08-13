package com.user;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.queuess.Job;
import com.queuess.Thread1;
import com.queuess.Thread2;

public class MainThreadQueue {
	 public static void main(String[] args) throws Exception {

	        BlockingQueue<Job> queue = new ArrayBlockingQueue<Job>(2);
	        Thread1 t1=new Thread1(queue);
	        Thread2 t2=new Thread2(queue);
	        Thread thread1=new Thread(t1);
	        Thread thread2=new Thread(t2);
	        thread1.start();
	        thread2.start();

	    }
}
