package com.queuess;
import java.util.concurrent.BlockingQueue;

import com.business.Job;
public class InsertionThread implements Runnable {
	
	protected BlockingQueue<Job> queue = null;
	private Job job;
	

    public InsertionThread(BlockingQueue<Job> queue,Job job) {
        this.queue = queue;
        this.job=job;
    }
    
	public void run() {
        try {
        	System.out.println("adding details are: "+job.getStudName()+" "+job.getStudMark1()+" "+job.getStudMark2()+" "+job.getStudMark3()+" "+job.calcPercentage());
        	queue.put(job);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
