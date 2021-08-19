package com.queuess;
import com.business.Job;

import java.util.concurrent.BlockingQueue;
public class Thread1 implements Runnable {
	
	protected BlockingQueue<Job> queue = null;
	private Job Job;
	

    public Thread1(BlockingQueue<Job> queue,Job job) {
        this.queue = queue;
        this.Job=job;
    }

	public void run() {
        try {
        	System.out.println("adding element: "+this.Job.square());
        	queue.put(this.Job);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


		
	
}
