package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class SoundsFishy2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWithNumberAsFirstLine.txt"
		));
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		if (a < b && b < c && c < d) {
			System.out.println("Fish Rising");
		} else if (a > b && b > c && c > d) {
			System.out.println("Fish Diving");
		} else if (a == b && b == c && c == d) {
			System.out.println("Fish At Constant Depth");
		} else {
			System.out.println("No Fish");
		}
		sc.close();
	}

}
