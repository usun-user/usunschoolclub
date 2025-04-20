package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DMOJ_AgeDemographic {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfViewers = sc.nextInt();
		int[] ages = new int[numberOfViewers];
		for (int i = 0; i < numberOfViewers; i++) {
			ages[i] = sc.nextInt();
		}
		int numberOfLines = sc.nextInt();
		
		for (int i = 0; i < numberOfLines; i++) {
			int low = sc.nextInt();
			int high = sc.nextInt();
			// ?
		}
		
		sc.close();
	}


}
