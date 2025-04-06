package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CodingContest4Problem3 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfCards = sc.nextInt();
		int numberOfLines = sc.nextInt();
		int numberOfCardsUp = numberOfCards;
		boolean[] arr = new boolean[numberOfCards];
		for (int i = 0; i < numberOfLines; i++) {
			int start = sc.nextInt();
			for (int end = sc.nextInt(); start <= end; start++) {
				boolean switchTo = !arr[start - 1];
				arr[start - 1] = switchTo;
				if (switchTo) {
					numberOfCardsUp--;
				} else {
					numberOfCardsUp++;
				}
			}
		}
		System.out.println(numberOfCardsUp);
		sc.close();
	}

}
