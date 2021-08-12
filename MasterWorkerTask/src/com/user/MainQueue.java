package com.user;
import com.queuess.*;
import java.util.LinkedList;
import java.util.*;
public class MainQueue {
	  
    public static void main(String args[])
    {
        Queue<Job> queue =new LinkedList<Job>();
		Job j=new Job(3);
	    	Job j1=new Job(4)
		System.out.println("adding element: "+j.getSquare());
	    	System.out.println("adding element: "+j1.getSquare());
		queue.add(j);
	    	queue.add(j1);
	    	System.out.println("before removing: "+queue.size());
	    	Job removedJob=queue.remove();
	    	System.out.println("removed element is: "+removedJob.getSquare());
	    	System.out.println("After removing: "+queue.size());
    }
}

