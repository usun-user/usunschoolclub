package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC25J3_ProductCodes {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int codeCount = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < codeCount; i++) {
			String originalCode = sc.nextLine();
			int codeLength = originalCode.length();
			
			String newCode = "";
			String currentIntString = "";
			int totalInt = 0;
			
			for (int j = 0; j < codeLength; j++) {
				char currentChar = originalCode.charAt(j);
				if (currentChar == '-') {
					if (currentIntString != "") {
						totalInt += Integer.parseInt(currentIntString);
						currentIntString = "";
					}
					currentIntString += currentChar;
				} else if (Character.isDigit(currentChar)) {
					currentIntString += currentChar;
				} else {
					if (currentIntString != "") {
						totalInt += Integer.parseInt(currentIntString);
						currentIntString = "";
					}
					if (Character.isUpperCase(currentChar)) {
						newCode += currentChar;
					}
				}
			}
			
			if (currentIntString != "") {
				totalInt += Integer.parseInt(currentIntString);
			}
			newCode += String.valueOf(totalInt);
			
			System.out.println(newCode);
		}
	}
}
