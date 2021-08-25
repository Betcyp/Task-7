package com.queuess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.business.Job;
import java.util.concurrent.BlockingQueue;



public class ReadCsvFile {

	protected BlockingQueue<Job> queue =new ArrayBlockingQueue<Job>(2);
//	private Job job;
	
	

	public void readCsvFile(String file) throws IOException {
		 BufferedReader br=new BufferedReader(new FileReader(file)); 
		 String line="";
		 try {
			 br.readLine();
			 while((line=br.readLine())!=null) {
				 String[] count= line.split(",");
				 System.out.println(count[0]+" " +count[1]+" "+count[2]+" "+count[3]);
				 int studMark1=Integer.parseInt(count[1]);
				 int studMark2=Integer.parseInt(count[2]);
				 int studMark3=Integer.parseInt(count[3]);
				 Job job=new Job();
				 job.setStudName(count[0]);
				 job.setStudMark1(studMark1);
				 job.setStudMark2(studMark2);
				 job.setStudMark3(studMark3);
				 InsertionThread t1=new InsertionThread(queue,job);
				 Thread thread1=new Thread(t1);
				 thread1.start();
			 }
		 }
		 catch(FileNotFoundException fe) {
			 fe.printStackTrace();
		 }
	}
	
	public Job fetch() throws InterruptedException {
		return queue.take();
	
	}
		
	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}
}	


	