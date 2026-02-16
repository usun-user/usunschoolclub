package edu.usun.schoolclub;

import java.util.*;
import java.io.*;

public class CCC22J5_SquarePool {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int gridLength = sc.nextInt();
		int treeCount = sc.nextInt();
		
		int maxLength = 1;
		
		//HashSet<int[]> treeSet = new HashSet<>();
		HashMap<Integer, ArrayList<Integer>> treeMap = new HashMap<>();
		
		for (int i = 0; i < treeCount; i++) {
			//treeSet.add(new int[] {sc.nextInt() - 1, sc.nextInt() - 1});
			int row = sc.nextInt() - 1;
			int column = sc.nextInt() - 1;
			
			ArrayList<Integer> current = treeMap.get(row);
			if (current == null) {
				current = new ArrayList<>();
			}
			current.add(column);
			treeMap.put(row, current);
		}
		
		for (int i = 0; i + maxLength <= gridLength; i++) {
			for (int j = 0; j + maxLength <= gridLength; j++) {
				//if (!treeSet.contains(new int[] {i, j})) {
				ArrayList<Integer> current = treeMap.get(i);
				if (current == null || !current.contains(j)) {
					int currentLength = 1;
					whileLoop:
					//while (i + currentLength + 1 <= gridLength && j + currentLength + 1 <= gridLength) {
					while (i + currentLength < gridLength && j + currentLength < gridLength) {
						for (int k = 0; k < currentLength + 1; k++) {
							//new bottom side
							//if (treeSet.contains(new int[] {i + currentLength, j + k})) {
							current = treeMap.get(i + currentLength);
							if (current != null && current.contains(j + k)) {
								break whileLoop;
							}
							//new right side
							//if (treeSet.contains(new int[] {i + k, j + currentLength})) {
							current = treeMap.get(i + k);
							if (current != null && current.contains(j + currentLength)) {
								break whileLoop;
							}
						}
						currentLength++;
					}
					maxLength = Math.max(maxLength, currentLength);
				}
			}
		}
		
		System.out.println(maxLength);
	}
}
