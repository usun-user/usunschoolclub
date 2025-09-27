package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class UCCCodingCompetition21P3_LongPizza_Faster {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		// had to change amountOfCheese into long
		sc.nextInt();
		int startEating = sc.nextInt();
		int endEating = sc.nextInt();
		int numberOfTasks = sc.nextInt();
		long amountOfCheese = 0;
		for (int i = 0; i < numberOfTasks; i++) {
			int startTime = sc.nextInt();
			int endTime = sc.nextInt();
			if (startTime < startEating && endTime >= startEating) {
				startTime = startEating;
			}
			if (endTime > endEating && startTime <= endEating) {
				endTime = endEating;
			}
			if (startTime >= startEating && endTime <= endEating) {
				amountOfCheese += endTime - startTime + 1;
			}
		}
		System.out.println(amountOfCheese);
		sc.close();
		/*
		// INCORRECT
		sc.nextInt();
		int startEating = sc.nextInt();
		int endEating = sc.nextInt();
		int numberOfTasks = sc.nextInt();
		int[] differenceArray = new int[endEating - startEating + 1];
		for (int i = 0; i < numberOfTasks; i++) {
			int startTime = sc.nextInt();
			int endTime = sc.nextInt() + 1;
			if (startTime >= startEating && startTime <= endEating) {
				differenceArray[startTime - startEating]++;
			} else if (startTime < startEating) {
				differenceArray[0]++;
			}
			if (endTime >= startEating && endTime <= endEating) {
				differenceArray[endTime - startEating]--;
			}
			System.out.println(Arrays.toString(differenceArray)); // debugging
		}
		System.out.println("next is psa:");
		int currentTotal = 0;
		int previousTotal = 0;
		int currentSum = 0;
		int previousSum = 0;
		for (int i = 0; i < endEating - startEating + 1; i++) {
			previousSum = currentSum;
			currentSum = previousSum + differenceArray[i];
			previousTotal = currentTotal;
			currentTotal = previousTotal + currentSum;
		}
		System.out.println(currentTotal);
		sc.close();
		*/
	}

}
