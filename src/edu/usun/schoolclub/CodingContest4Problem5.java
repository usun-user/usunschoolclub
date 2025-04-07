package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class CodingContest4Problem5 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int timeMax = sc.nextInt();
		int dataPoints = sc.nextInt();
		int lines = sc.nextInt();
		int totalChanges = 0;
		for (int i = 0; i < lines; i++) {
			int changes = sc.nextInt() * dataPoints;
			for (int j = 0; j < dataPoints; j++) {
				changes -= sc.nextInt();
			}
			totalChanges += Math.abs(changes);
		}
		if (totalChanges <= timeMax * 60) {
			System.out.println(totalChanges);
		} else {
			System.out.println(timeMax);
		}
		sc.close();
	}

}
