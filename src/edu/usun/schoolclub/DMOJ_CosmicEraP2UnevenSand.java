package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DMOJ_CosmicEraP2UnevenSand {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		long low = 1;
		long high = (long)(2e9);
		while (true) {
			long pointer = (high + low) / 2;
			System.out.println(pointer);
			System.out.flush();
			switch (sc.nextLine()) {
				case "FLOATS":
					high = pointer - 1;
					break;
				case "SINKS":
					low = pointer + 1;
					break;
				default:
					sc.close();
					return;
			}
		}
	}

}
