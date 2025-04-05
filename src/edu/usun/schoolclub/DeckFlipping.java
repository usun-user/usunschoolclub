package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class DeckFlipping {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"
		));
		int numberOfCards = sc.nextInt();
		int numberOfLines = sc.nextInt();
		int numberOfCardsUp = 0;
		int[] arr = new int[numberOfCards];
		for (int i = 0; i < numberOfLines; i++) {
			int start = sc.nextInt();
			for (int end = sc.nextInt(); start <= end; start++) {
				arr[start-1]++;
			}	
		}
		for (int j = 0; j < numberOfCards; j++) {
			if (arr[j] % 2 == 0) {
				numberOfCardsUp++;
			}
		}	
		System.out.println(numberOfCardsUp);
		sc.close();
	}

}
