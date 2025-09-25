package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;
//import java.util.Arrays; // debugging

public class DMOJ_HardcoreGrinding {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfTasks = sc.nextInt();
		int numberOfMachines = 0;
		int maxTime = 0;
		for (int i = 0; i < numberOfTasks; i++) {
			sc.nextInt(); // skip integer
			int endTime = sc.nextInt();
			if (maxTime < endTime) {
				maxTime = endTime;
			}
		}
		int[] differenceArray = new int[maxTime];
		sc.close();
		sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		sc.nextInt(); // skip integer
		for (int i = 0; i < numberOfTasks; i++) {
			differenceArray[sc.nextInt() - 1]++;
			differenceArray[sc.nextInt() - 1]--;
			//System.out.println(Arrays.toString(differenceArray));
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
