package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC23J3_SpecialEvent {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int peopleCount = sc.nextInt();
		sc.nextLine();
		
		int[] days = new int[5];
		
		for (int i = 0; i < peopleCount; i++) {
			String person = sc.nextLine();
			for (int j = 0; j < 5; j++) {
				if (person.charAt(j) == 'Y') {
					days[j]++;
				}
			}
		}
		
		int currentMax = 0;
		boolean isFirstDay = true;
		String output = "";
		
		for (int i = 0; i < 5; i++) {
			if (days[i] > currentMax) {
				currentMax = days[i];
				output = Integer.toString(i + 1);
				isFirstDay = false;
			} else if (days[i] == currentMax) {
				if (isFirstDay) {
					output = Integer.toString(i + 1);
				} else {
					output += "," + Integer.toString(i + 1);
				}
			}
		}
		System.out.println(output);
	}
}
