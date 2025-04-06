package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CodingContest4Problem1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWithNumberAsFirstLine.txt"));
		int numberOfLines = sc.nextInt();
		if (numberOfLines <= 0) {
			System.out.println("No lines to read.");
			sc.close();
			return;
		}
		sc.nextLine();
		String myHand = sc.nextLine();
		int myHandValue = 0;
		if ("HIGH CARD".equals(myHand)) {
			myHandValue = 1;
		} else if ("PAIR".equals(myHand)) {
			myHandValue = 2;
		} else if ("TWO PAIR".equals(myHand)) {
			myHandValue = 3;
		} else if ("THREE OF A KIND".equals(myHand)) {
			myHandValue = 4;
		} else if ("STRAIGHT".equals(myHand)) {
			myHandValue = 5;
		} else if ("FLUSH".equals(myHand)) {
			myHandValue = 6;
		} else if ("FULL HOUSE".equals(myHand)) {
			myHandValue = 7;
		} else if ("FOUR OF A KIND".equals(myHand)) {
			myHandValue = 8;
		} else if ("STRAIGHT FLUSH".equals(myHand)) {
			myHandValue = 9;
		} else if ("ROYAL FLUSH".equals(myHand)) {
			myHandValue = 10;
		}
		int wins = 0;
		int ties = 0;
		int losses = 0;
		int otherHandValue = 0;
		for (int i = 0; i < numberOfLines; i++) {
			String otherHand = sc.nextLine();
			if ("HIGH CARD".equals(otherHand)) {
				otherHandValue = 1;
			} else if ("PAIR".equals(otherHand)) {
				otherHandValue = 2;
			} else if ("TWO PAIR".equals(otherHand)) {
				otherHandValue = 3;
			} else if ("THREE OF A KIND".equals(otherHand)) {
				otherHandValue = 4;
			} else if ("STRAIGHT".equals(otherHand)) {
				otherHandValue = 5;
			} else if ("FLUSH".equals(otherHand)) {
				otherHandValue = 6;
			} else if ("FULL HOUSE".equals(otherHand)) {
				otherHandValue = 7;
			} else if ("FOUR OF A KIND".equals(otherHand)) {
				otherHandValue = 8;
			} else if ("STRAIGHT FLUSH".equals(otherHand)) {
				otherHandValue = 9;
			} else if ("ROYAL FLUSH".equals(otherHand)) {
				otherHandValue = 10;
			}
			if (myHandValue > otherHandValue) {
				wins++;
			} else if (myHandValue == otherHandValue) {
				ties++;
			} else if (myHandValue < otherHandValue) {
				losses++;
			}
		}
		System.out.println(wins + " " + ties + " " + losses);
		sc.close();
	}

}
