package com.queuess;
import java.util.concurrent.BlockingQueue;

import com.business.Job;

public class RemovedThread implements Runnable {
	BlockingQueue<Job> queue = null;

    public RemovedThread(BlockingQueue<Job> queue) {
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
