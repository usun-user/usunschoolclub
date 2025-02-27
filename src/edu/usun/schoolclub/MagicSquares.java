package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class MagicSquares {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"
		));
		
		/*
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println("Read line: " + line);
		}
		sc.close();
		*/
		
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}			
			};
			
			//accessing item at certain position
			//System.out.println(matrix[1][1]);
			
			/*
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			*/
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
	}

}
