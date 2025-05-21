package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class MockCCO19Contest2Problem4_AGeometryProblem {

	/*
	public static int cut(int n, int y, int x) {
		// Base case
		if (x == 0 || y == 1) {
			//return 1;
		}
		// Recursive case
		else {
			//return n * cut(n - 1);
		}
		
		// ?
	}
	*/
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = sc.nextInt();
		//System.out.println(cut(n - 1));
		sc.close();
	}
	
}
