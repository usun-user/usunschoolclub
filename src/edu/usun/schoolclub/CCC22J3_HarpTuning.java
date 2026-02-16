package edu.usun.schoolclub;

import java.util.*;
import java.io.*;

public class CCC22J3_HarpTuning {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int length = input.length();
		
		boolean isPreviousDigit = false;
		
		for (int i = 0; i < length; i++) {
			char currentChar = input.charAt(i);
			if (Character.isLetter(currentChar)) {
				if (isPreviousDigit) {
					isPreviousDigit = false;
					System.out.println();
				}
				System.out.print(currentChar);
			} else if (currentChar == '+') {
				System.out.print(" tighten ");
			} else if (currentChar == '-') {
				System.out.print(" loosen ");
			} else {
				System.out.print(currentChar);
				isPreviousDigit = true;
			}
		}
	}
}
