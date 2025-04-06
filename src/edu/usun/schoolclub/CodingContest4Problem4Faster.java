package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CodingContest4Problem4Faster {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int input = sc.nextInt();
		double output = (-1 + Math.sqrt(1 + (8 * input))) / 2;
		System.out.println((int)output);
		sc.close();
	}

}
