package com.user;

import java.io.IOException;
import com.business.Job;
import com.queuess.ReadCsvFile;

public class MainReadCsvFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		String file="c:\\java\\JobFiles.csv";
		ReadCsvFile csv=new ReadCsvFile();
		csv.readCsvFile(file);
		Thread.sleep(500);
		while(csv.isQueueEmpty()==false) {
			Job j1=csv.fetch();
			System.out.println("fetched items are:"+j1.getStudName()+" "+j1.getStudMark1()+" "+j1.getStudMark2()+" "+j1.getStudMark3()+" "+j1.calcPercentage());
		}
	}
}
