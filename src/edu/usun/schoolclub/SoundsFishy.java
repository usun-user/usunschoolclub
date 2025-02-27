package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class SoundsFishy {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWithNumberAsFirstLine.txt"
		));
		int a = sc.nextInt();
		int b = 0;
		
		for (int i = 0; i < 3; i++) {
			sc.nextLine();
			int x = sc.nextInt();
			if (x > a) {
				b++;
			} else if (x < a) {
				b--;
			}
			a = x;
		}
		
		if (b == 3) {
			System.out.println("Fish Rising");
		} else if (b == 0) {
			System.out.println("Fish At Constant Depth");
		} else if (b == -3) {
			System.out.println("Fish Diving");
		} else {
			System.out.println("No Fish");
		}
		
		sc.close();
	}

}
