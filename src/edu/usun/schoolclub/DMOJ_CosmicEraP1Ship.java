package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class DMOJ_CosmicEraP1Ship {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		String input = sc.nextLine();
		boolean[] letters = new boolean[5];
		for (int i = 0, n = input.length(); i < n; i++) {
			switch (input.charAt(i)) {
			case 'B':
				letters[0] = true;
				break;
			case 'F':
				letters[1] = true;
				break;
			case 'T':
				letters[2] = true;
				break;
			case 'L':
				letters[3] = true;
				break;
			case 'C':
				letters[4] = true;
				break;
			}
		}
		boolean noMissingParts = true;
		if (!letters[0]) {
			System.out.println("B");
			noMissingParts = false;
		}
		if (!letters[1]) {
			System.out.println("F");
			noMissingParts = false;
		}
		if (!letters[2]) {
			System.out.println("T");
			noMissingParts = false;
		}
		if (!letters[3]) {
			System.out.println("L");
			noMissingParts = false;
		}
		if (!letters[4]) {
			System.out.println("C");
			noMissingParts = false;
		}
		if (noMissingParts) {
			System.out.println("NO MISSING PARTS");
		}
		
		// above code is better than below code
		/*	
		boolean noMissingParts = true;	
		if (!input.contains("B")) {
			System.out.println("B");
			noMissingParts = false;
		}
		if (!input.contains("F")) {
			System.out.println("F");
			noMissingParts = false;
		}
		if (!input.contains("T")) {
			System.out.println("T");
			noMissingParts = false;
		}
		if (!input.contains("L")) {
			System.out.println("L");
			noMissingParts = false;
		}
		if (!input.contains("C")) {
			System.out.println("C");
			noMissingParts = false;
		}
		if (noMissingParts) {
			System.out.println("NO MISSING PARTS");
		} 
		*/
		sc.close();
	}

}
