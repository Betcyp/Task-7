package com.queuess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

import com.business.Job;
import java.util.concurrent.BlockingQueue;

public class CreateCsv {

	public void createCsvFile() {
	  
	  StringBuilder str = new StringBuilder();
	  
	  str.append("StudName").append(",").append("Sub").append(",").append("StudMark").append("\n");
	  
	  str.append("Anu").append(",").append("English").append(",").append("20").append("\n");
	  
	  str.append("Blesson").append(",").append("Science").append(",").append("25");
	  
	 try(FileWriter fw= new FileWriter("c:\\java\\JobFiles.csv"))
	 {
		   fw.write(str.toString());
		   System.out.println("CSV file is created");
	   
	  } 
	 catch(Exception e) 
	 { 
		  e.printStackTrace();
	  }
	}
	public void readCsvFile() throws IOException {
		 BlockingQueue<Job> queue =new ArrayBlockingQueue<Job>(2);
		 BufferedReader br=new BufferedReader(new FileReader("c:\\java\\JobFiles.csv")); 
		 String line="";
		 try {
			 br.readLine();
			 while((line=br.readLine())!=null) {
				 String[] count= line.split(",");
				 System.out.println(count[0]+" " +count[1]+" "+count[2]);
				 int StudMark=Integer.parseInt(count[2]);
				 Job job=new Job(StudMark);
				 Thread1 t1=new Thread1(queue,job);
				 Thread thread1=new Thread(t1);
				 thread1.start();
			 }
			 Thread2 t2=new Thread2(queue);
			 Thread thread2=new Thread(t2);
			 thread2.start();
		 }
		 catch(FileNotFoundException fe) {
			 fe.printStackTrace();
		 }
	}

}	