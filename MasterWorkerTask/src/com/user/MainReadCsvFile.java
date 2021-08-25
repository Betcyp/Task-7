package com.user;

import java.io.IOException;

import com.business.Job;
import com.queuess.ReadCsvFile;

public class MainReadCsvFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		String file="c:\\java\\JobFiles.csv";
		ReadCsvFile csv=new ReadCsvFile();
		csv.readCsvFile(file);
		csv.fetch();
		Job job=csv.fetch();
		System.out.println(job.calc_percentage());
		
	}
}
