package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GW_ImposterFriends {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfFriends = sc.nextInt();
		int numberOfOthers = sc.nextInt();
		Set<Integer> validFriends = new HashSet<>();
		for (int i = 0; i < numberOfFriends; i++) {
			validFriends.add(sc.nextInt());
		}
		StringBuilder output = new StringBuilder();
		String lineBreak = System.getProperty("line.separator", "\n");
		for (int i = 0; i < numberOfOthers; i++) {
			if (validFriends.contains(sc.nextInt())) {
				//System.out.println("yes");
				output.append("yes");
			} else {
				//System.out.println("no");
				output.append("no");
			}
			output.append(lineBreak);
		}
		System.out.print(output);
		sc.close();
	}


}
