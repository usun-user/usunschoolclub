package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class GW_CidsPlaylist {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfLines = sc.nextInt();
		for (int i = 0; i < numberOfLines; i++) {
			int hours = sc.nextInt();
			int minutes = sc.nextInt();
			int seconds = sc.nextInt();
			System.out.println((hours * 3600) + (minutes * 60) + seconds);
		}
		sc.close();
	}

}


