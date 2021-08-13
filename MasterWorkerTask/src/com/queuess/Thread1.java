package com.queuess;
import java.util.concurrent.BlockingQueue;

public class Thread1 implements Runnable {
	
	protected BlockingQueue<Job> queue = null;

    public Thread1(BlockingQueue<Job> queue) {
        this.queue = queue;
    }


	public void run() {
        try {
        	Job j=new Job(2);
        	System.out.println("adding element: "+j.getSquare());
        	queue.put(j);
        	Job j1=new Job(3);
        	System.out.println("adding element: "+j1.getSquare());
            queue.put(j1);
            queue.put(null);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch(NullPointerException ne) {
        	ne.printStackTrace();
        }
    }
}
