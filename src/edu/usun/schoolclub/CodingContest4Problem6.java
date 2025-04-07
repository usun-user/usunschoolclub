package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CodingContest4Problem6 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int lengthWidth = sc.nextInt();
		int numberOfBoxes = sc.nextInt();
		int keyX = sc.nextInt();
		int keyY = sc.nextInt();
		int maxMoves = sc.nextInt();
		int minimumMoves = 0;
		
		for (int i = 0; i < numberOfBoxes; i++) {
			
		}
		for (int i = 0; i < numberOfBoxes; i++) {
			
		}
		
		if (minimumMoves <= maxMoves) {
			System.out.println(minimumMoves);
		} else {
			System.out.println(maxMoves);
		}
		sc.close();
	}

}
