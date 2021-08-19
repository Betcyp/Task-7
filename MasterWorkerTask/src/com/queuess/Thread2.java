package com.queuess;
import java.util.concurrent.BlockingQueue;

import com.business.Job;

public class Thread2 implements Runnable {
	BlockingQueue<Job> queue = null;

    public Thread2(BlockingQueue<Job> queue) {
        this.queue = queue;
    }


	public void run() {
        try {
        	Job j=queue.take();
            System.out.println("removed element is:" +j.square());

        }
        
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
