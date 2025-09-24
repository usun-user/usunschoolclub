package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class DMOPC14Contest2P4_Deforestation {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfTrees = sc.nextInt();
		//int[] arrayOfMasses = new int[numberOfTrees];
		int[] massPSA = new int[numberOfTrees + 1];
		for (int i = 0; i < numberOfTrees; i++) {
			//arrayOfMasses[i] = sc.nextInt();
			//massPSA[i + 1] = arrayOfMasses[i] + massPSA[i];
			massPSA[i + 1] = sc.nextInt() + massPSA[i];
		}
		int numberOfQueries = sc.nextInt();
		for (int j = 0; j < numberOfQueries; j++) {
			int lowRange = sc.nextInt();
			int highRange = sc.nextInt();
			int mass = massPSA[highRange + 1] - massPSA[lowRange];
			// using PSA (Prefix Sum Array) add the highRange+1 value and subtract the lowRange value.
			System.out.println(mass);
		}
		sc.close();
	}

}
