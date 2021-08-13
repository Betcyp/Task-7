package com.queuess;
//import com.queuess.Job;
import java.util.concurrent.BlockingQueue;

public class Thread2 implements Runnable {
	BlockingQueue<Job> queue = null;

    public Thread2(BlockingQueue<Job> queue) {
        this.queue = queue;
    }


	public void run() {
        try {
        	Job job=queue.take();
            System.out.println("removed element is:" +job.getSquare());
        }
        
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch(NullPointerException ne) {
        	ne.printStackTrace();
        	
        }
        
    }

}
