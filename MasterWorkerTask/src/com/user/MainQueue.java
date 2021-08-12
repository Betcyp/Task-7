package com.user;
import com.queuess.*;
import java.util.LinkedList;
import java.util.*;
public class MainQueue {
	  
    public static void main(String args[])
    {
        Queue<Job> queue =new LinkedList<Job>();
		Job j=new Job(3);
		System.out.println("adding element: "+j.getSquare());
		queue.add(j);
		Job removedJob=queue.remove();
		System.out.println("removed element: "+removedJob.getSquare());
    }
}

