package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class MagicSquares {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int[][] magicSquare = new int[4][4];
		int value = 0;
		for (int i = 0; i < 4; i++) {
			int currentValue = 0;
			for (int j = 0; j < 4; j++) {
				magicSquare[i][j] = sc.nextInt();
				currentValue += magicSquare[i][j];
			}
			if (currentValue != value) {
				if (i == 0) {
					value = currentValue;
				} else {
					System.out.println("not magic");
					sc.close();
					return;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			int currentValue = 0;
			for (int j = 0; j < 4; j++) {
				currentValue += magicSquare[j][i];
			}
			if (currentValue != value) {
				System.out.println("not magic");
				sc.close();
				return;
			}
		}
		System.out.println("magic");	
		sc.close();
	}

}
