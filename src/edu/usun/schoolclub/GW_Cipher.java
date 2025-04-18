package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.HashMap;

public class GW_Cipher {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfDays = sc.nextInt();
		int numberOfChanges = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numberOfDays; i++) {
			HashMap<Character, Character> charMap = new HashMap<>();
			for (int j = 0; j < numberOfChanges; j++) {
				String change = sc.nextLine();
				charMap.put(change.charAt(0), change.charAt(2));
			}
			StringBuilder message = new StringBuilder(sc.nextLine());
			int length = message.length();
			for (int j = 0; j < length; j++) {
				if (charMap.containsKey(message.charAt(j))) {
					message.setCharAt(j, charMap.get(message.charAt(j)));	
				}
			}
			System.out.println(message);
		}
		sc.close();
	}

}


