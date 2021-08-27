package com.user;
import com.business.Job;
import com.databases.DatabaseConn;
import com.queuess.ReadCsvFile;
public class MainReadCsvFile {

	public static void main(String[] args) throws Exception {
		String file="c:\\java\\JobFiles.csv";
		ReadCsvFile csv=new ReadCsvFile();
		csv.readCsvFile(file);
		Thread.sleep(500);
		DatabaseConn db=new DatabaseConn();
		while(csv.isQueueEmpty()==false) {
			Job j1=csv.fetch();
			System.out.println("fetched items are:"+j1.getStudName()+" "+j1.getStudMark1()+" "+j1.getStudMark2()+" "+j1.getStudMark3()+" "+j1.calcPercentage());
			db.insert(j1);
		}
	}
}

