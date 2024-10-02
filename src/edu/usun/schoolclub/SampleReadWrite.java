package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class SampleReadWrite {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\repo\\github\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"
		));
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println("Read line: " + line);
		}
	}

}
