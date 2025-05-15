package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class GreedyAlgorithm {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		
		// Greedy Algorithm example 1: Minimum number of coins (take largest coin each time)
		/*
		int[] coinsArray = {25, 10, 5, 1};
		int target = 30;
		int numberOfCoins = 0;
		
		while (target > 0) {
			for (int j = 0; j < coinsArray.length; j++) {
				if (coinsArray[j] <= target) {
					numberOfCoins++;
					target -= coinsArray[j];
					break;
				}
			}
		}
		
		System.out.println(numberOfCoins);
		sc.close();
		*/
		
		// Greedy Algorithm example: Maximum number of activities (always pick smallest finish time)
		
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] finish = {2, 4, 6, 7, 9, 9};
		int currentTime = 0;
		int numberOfActivities = 0;
		
		HashMap<Integer, Integer> activitiesMap = new HashMap<Integer, Integer>();
		
		int lengthOfArray = finish.length;
		
		for (int i = 0; i < lengthOfArray; i++) {
			if (activitiesMap.get(finish[i]) == null || activitiesMap.get(finish[i]) < start[i]) {
				activitiesMap.put(finish[i], start[i]);
			}
		}
		
		Arrays.sort(finish);
		
		for (int i = 0; i < lengthOfArray; i++) {
			if (activitiesMap.get(finish[i]) >= currentTime) {
				numberOfActivities++;
				currentTime = finish[i];
			}
		}
		
		System.out.println(numberOfActivities);
		sc.close();
		
	}

}
