package com.queuess;
import com.business.Job;

import java.util.concurrent.BlockingQueue;
public class InsertionThread implements Runnable {
	
	protected BlockingQueue<Job> queue = null;
	private Job job;
	

    public InsertionThread(BlockingQueue<Job> queue,Job job) {
        this.queue = queue;
        this.job=job;
    }

	public void run() {
        try {
        	System.out.println("adding details are: "+job.getStudName()+" "+job.getSub()+" "+job.square()+" "+job.cube());
        	//System.out.println("adding details are: "+Job.square());
        	//System.out.println("adding details are: "+Job.cube());
        	queue.put(job);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
