package com.orangehrm.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

	public static void main(String[] args) throws IOException {

		String csvFile = "C:\\Users\\vzodge\\Documents\\Vaibhav\\Study\\My Presentations\\Selenium Training Profound\\Batch 2\\CSVFile.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {

			// use comma as separator
			String[] country = line.split(cvsSplitBy);			
			System.out.println(line);

		}
	}
}
