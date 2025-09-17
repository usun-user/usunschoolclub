package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class DMOPC14Contest2P4_Deforestation {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		//int x = 10;
		//String mySentence = "hello world";
		//boolean tired = true;
		//float myFloat = 5.6f;
		
		int numberOfTrees = sc.nextInt();
		int[] arrayOfTrees = new int[numberOfTrees];
		for (int i = 0; i < numberOfTrees; i++) {
			arrayOfTrees[numberOfTrees] = sc.nextInt();
		}
		int numberOfQueries = sc.nextInt();
		for (int j = 0; j < numberOfQueries; j++) {
			
		}
		
		//System.out.println(x + mySentence + tired + myFloat);
		sc.close();
	}

}
