package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class ConformingMultiples {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"
		));
		int maximumNumber = sc.nextInt();
		int divisor = sc.nextInt();
		int outputNumber = 0;
		int holder = 0;
		
		for (int i = 1; outputNumber < maximumNumber; i++) {
			holder = divisor*i;
			String str = Integer.toString(holder);
			int count0 = 0;
			for (int a = 0; a < str.length(); a++) {
				if(str.charAt(a) == '0') {
					count0++;
				} 
			}
		}
		
		
		System.out.println(outputNumber);
		sc.close();
	}

}
