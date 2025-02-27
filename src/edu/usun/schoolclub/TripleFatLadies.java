package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class TripleFatLadies {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWithNumberAsFirstLine.txt"
		));
		int numberOfLines = sc.nextInt();
		if (numberOfLines <= 0) {
			System.out.println("No lines to read.");
			sc.close();
			return;
		}	
		// Complete the first line, as readInt doesn't do it.
		sc.nextLine();
		
		for (int i = 0; i < numberOfLines; i++) {
			int k = sc.nextInt();
			
			System.out.println("answer");
		}
		
		sc.close();
	}

}
