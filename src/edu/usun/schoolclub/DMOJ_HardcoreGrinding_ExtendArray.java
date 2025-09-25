package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;
//import java.util.Arrays; // debugging

public class DMOJ_HardcoreGrinding_ExtendArray {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfTasks = sc.nextInt();
		int numberOfMachines = 0;
		int[] differenceArray = new int[3];
		
		for (int i = 0; i < numberOfTasks; i++) {
			int startTime = sc.nextInt();
			int endTime = sc.nextInt();
			if (endTime > differenceArray.length) {
				int[] newDifferenceArray = new int[endTime * 2];
				System.arraycopy(differenceArray, 0, newDifferenceArray, 0, differenceArray.length);
				differenceArray = newDifferenceArray;
			}
			differenceArray[startTime - 1]++;
			differenceArray[endTime - 1]--;
			//System.out.println(Arrays.toString(differenceArray)); // debugging
		}
		
		int currentNumberOfMachines = 0;
		for (int i = 0; i < differenceArray.length; i++) {
			currentNumberOfMachines += differenceArray[i];
			if (numberOfMachines < currentNumberOfMachines) {
				numberOfMachines = currentNumberOfMachines;
			}
		}
		
		System.out.println(numberOfMachines);
		sc.close();
	}

}
