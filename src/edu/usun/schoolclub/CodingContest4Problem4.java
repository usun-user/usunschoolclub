package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CodingContest4Problem4 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int inputNumber = sc.nextInt();
		int currentNumber = 0;
		int numberOfFactors = 1;	
		for (numberOfFactors = 1; currentNumber < inputNumber; numberOfFactors++) {
			currentNumber = numberOfFactors * (numberOfFactors + 1) / 2;
		}	
		System.out.println(numberOfFactors - 1);
		sc.close();
	}

}
