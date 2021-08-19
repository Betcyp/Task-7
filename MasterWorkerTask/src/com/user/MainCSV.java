package com.user;

import java.io.IOException;

import com.queuess.CreateCsv;

public class MainCSV {
	public static void main(String[] args) throws IOException {
		CreateCsv csv=new CreateCsv();
		csv.createCsvFile();
		csv.readCsvFile();
	}
}
