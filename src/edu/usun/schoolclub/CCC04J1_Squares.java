package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CCC04J1_Squares {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		System.out.println("The largest square has side length " + (int) Math.sqrt(sc.nextInt()) + ".");
		sc.close();
	}

}
