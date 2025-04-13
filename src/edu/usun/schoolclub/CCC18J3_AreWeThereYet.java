package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.HashMap;

public class CCC18J3_AreWeThereYet {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		HashMap<Integer, Integer> distanceMap = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			distanceMap.put(i, sc.nextInt());
		}
		for (int i = 0; i < 5; i++) {
			String row = "";
			for (int j = 0; j < 5; j++) {
				int counter = 0;
				int max = Math.max(i, j);
				for (int min = Math.min(i, j); min < max; min++) {
					counter += distanceMap.get(min);
				}
				row += counter + " ";
			}
			System.out.println(row.substring(0, row.length() - 1));
		}
		sc.close();
	}

}


