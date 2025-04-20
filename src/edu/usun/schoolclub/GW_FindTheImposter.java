package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class GW_FindTheImposter {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfMistakes = 0;
		for (int i = 0; i < 5; i++) {
			long[] numberArray = {sc.nextLong(), sc.nextLong(), sc.nextLong(), sc.nextLong(), sc.nextLong()};
			for (int j = 1; j < 4; j++) {
				if ((numberArray[j] - numberArray[j - 1]) != (numberArray[j + 1] - numberArray[j])) {
					numberOfMistakes++;
					break;
				}
			}
		}
		System.out.println(numberOfMistakes);
		sc.close();	
	}

}
