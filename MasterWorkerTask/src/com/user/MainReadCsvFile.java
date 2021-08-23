package com.user;

import java.io.IOException;

import com.queuess.ReadCsvFile;

public class MainReadCsvFile {
	public static void main(String[] args) throws IOException {
		String file="c:\\java\\JobFiles.csv";
		ReadCsvFile csv=new ReadCsvFile();
		csv.readCsvFile(file);
	}
}
