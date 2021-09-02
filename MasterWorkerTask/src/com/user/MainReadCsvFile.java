package com.user;
import com.databases.DatabaseConn;
import com.queuess.ReadCsvFile;
public class MainReadCsvFile {

	public static void main(String[] args) throws Exception {
		String file="c:\\java\\JobFiles.csv";
		ReadCsvFile csv=new ReadCsvFile();
		csv.readCsvFile(file);
		Thread.sleep(500);
		DatabaseConn db=new DatabaseConn();
		String file1=args[0];
		db.getConnection(file1);
		db.insertDataInToDatabase(csv, file1);
	}
}

