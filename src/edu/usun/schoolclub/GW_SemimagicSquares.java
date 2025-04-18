package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class GW_SemimagicSquares {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int width = sc.nextInt();
		int[][] magicSquare = new int[width][width];
		int value = 0;
		for (int i = 0; i < width; i++) {
			int currentValue = 0;
			for (int j = 0; j < width; j++) {
				magicSquare[i][j] = sc.nextInt();
				currentValue += magicSquare[i][j];
			}
			if (currentValue != value) {
				if (i == 0) {
					value = currentValue;
				} else {
					System.out.println("no");
					sc.close();
					return;
				}
			}
		}
		for (int i = 0; i < width; i++) {
			int currentValue = 0;
			for (int j = 0; j < width; j++) {
				currentValue += magicSquare[j][i];
			}
			if (currentValue != value) {
				System.out.println("no");
				sc.close();
				return;
			}
		}
		int firstDiagonal = 0;
		int secondDiagonal = 0;
		for (int i = 0; i < width; i++) {
			firstDiagonal += magicSquare[i][i];
			secondDiagonal += magicSquare[width - 1 - i][width - 1 - i];
		}
		if (firstDiagonal == value && secondDiagonal == value) {
			System.out.println("no");
		} else {
			System.out.println("yes");	
		}
		sc.close();
	}

}
