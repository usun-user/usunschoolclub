package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * A sample to read data from a file, but just N lines starting from a second one, where number N is in the first line.
 */
public class TandemBicycle {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWithNumberAsFirstLine.txt"
		));
		
		int question = sc.nextInt();
		int numberOfIntegers = sc.nextInt();
		
		// Minimum
		if (question == 1) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(Math.max(a, b));
		}	
		
		// Maximum
		if (question == 2) {
			
		}
		
		for (int i = 0; i < question; i++) {
			String line = sc.nextLine();
			System.out.println("Read line: " + line);
		}
		
		sc.close();
	}

}
