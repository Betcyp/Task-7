package com.queuess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

import com.business.Job;
import java.util.concurrent.BlockingQueue;

public class ReadCsvFile {

	public void readCsvFile(String file) throws IOException {
		 BlockingQueue<Job> queue =new ArrayBlockingQueue<Job>(2);
		 BufferedReader br=new BufferedReader(new FileReader(file)); 
		 String line="";
		 try {
			 br.readLine();
			 while((line=br.readLine())!=null) {
				 String[] count= line.split(",");
				 System.out.println(count[0]+" " +count[1]+" "+count[2]);
				 int studMark=Integer.parseInt(count[2]);
				 Job job=new Job();
				 job.setStudName(count[0]);
				 job.setSub(count[1]);
				 job.setStudMark(studMark);
				 InsertionThread t1=new InsertionThread(queue,job);
				 Thread thread1=new Thread(t1);
				 thread1.start();
			 }
		 }
		 catch(FileNotFoundException fe) {
			 fe.printStackTrace();
		 }
	}

}	