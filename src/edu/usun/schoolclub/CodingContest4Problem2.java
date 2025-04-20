package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CodingContest4Problem2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int maximumNumber = sc.nextInt();
		int divisor = sc.nextInt();
		int currentNumber = 0;
		int currentMax = 0;
		int outputNumber = 0;
		for (int i = 1; divisor * i <= maximumNumber; i++) {
			currentNumber = divisor * i;
			String str = Integer.toString(currentNumber);
			int count0 = 0;
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int count5 = 0;
			int count6 = 0;
			int count7 = 0;
			int count8 = 0;
			int count9 = 0;
			for (int a = 0; a < str.length(); a++) {
				switch (str.charAt(a)) {
					case '0':
						count0++;
						break;
					case '1':
						count1++;
						break;
					case '2':
						count2++;
						break;
					case '3':
						count3++;
						break;
					case '4':
						count4++;
						break;
					case '5':
						count5++;
						break;
					case '6':
						count6++;
						break;
					case '7':
						count7++;
						break;
					case '8':
						count8++;
						break;
					case '9':
						count9++;
						break;
				}
				
				/*
				if (str.charAt(a) == '0') {
					count0++;
				} else if (str.charAt(a) == '1') {
					count1++;
				} else if (str.charAt(a) == '2') {
					count2++;
				} else if (str.charAt(a) == '3') {
					count3++;
				} else if (str.charAt(a) == '4') {
					count4++;
				} else if (str.charAt(a) == '5') {
					count5++;
				} else if (str.charAt(a) == '6') {
					count6++;
				} else if (str.charAt(a) == '7') {
					count7++;
				} else if (str.charAt(a) == '8') {
					count8++;
				} else if (str.charAt(a) == '9') {
					count9++;
				}
				*/
			}
			int max = Math.max(count0, Math.max(count1, Math.max(count2, Math.max(count3, Math.max(count4,
					Math.max(count5, Math.max(count6, Math.max(count7, Math.max(count8, count9)))))))));
			if (max >= currentMax) {
				currentMax = max;
				outputNumber = currentNumber;
			}
		}
		System.out.println(outputNumber);
		sc.close();
	}

}
