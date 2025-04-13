package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CCC20J4_CyclicShifts {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		String text = sc.nextLine();
		String string = sc.nextLine();
		int stringLength = string.length();
		boolean found = false;
		for (int i = 0; i < stringLength; i++) {
			String cyclicShift = "";
			for (int j = 0; j < stringLength; j++) {
				int charIndex = j + i;
				if (charIndex >= stringLength) {
					charIndex -= stringLength;
				}
				cyclicShift += string.charAt(charIndex);
			}
			if (text.contains(cyclicShift)) {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		sc.close();
	}

}


