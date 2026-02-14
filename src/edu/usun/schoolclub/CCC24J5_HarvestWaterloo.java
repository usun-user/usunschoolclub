package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC24J5_HarvestWaterloo {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rowCount = Integer.parseInt(br.readLine());
		int columnCount = Integer.parseInt(br.readLine());
		
		char[][] patchArr = new char[rowCount][columnCount];
		int totalValue = 0;
		
		for (int i = 0; i < rowCount; i++) {
			String currentRow = br.readLine();
			for (int j = 0; j < columnCount; j++) {
				patchArr[i][j] = currentRow.charAt(j);
			}
		}
		
		int startRow = Integer.parseInt(br.readLine());
		int startColumn = Integer.parseInt(br.readLine());
		
		Queue<int[]> queue = new LinkedList<>(); 
		queue.add(new int[] {startRow, startColumn});
		
		// In real life, better to make a public static class (can call it Position) to store the row and column.
		// So instead it would be: Queue<Position> queue = new LinkedList<>();
		// But in contest, int[] of size 2 is faster (both for performance and time it takes to type).
		
		while (!queue.isEmpty()) {
			int[] position = queue.poll();
			int row = position[0];
			int column = position[1];
			
			if (patchArr[row][column] == '*') {
				continue;
			} else if (patchArr[row][column] == 'S') {
				totalValue += 1;
			} else if (patchArr[row][column] == 'M') {
				totalValue += 5;
			} else {
				totalValue += 10;
			}
			
			patchArr[row][column] = '*';
			
			if ((row + 1 < rowCount) && (patchArr[row + 1][column] != '*')) {
				queue.add(new int[] {row + 1, column});
			}
			if ((row - 1 > -1) && (patchArr[row - 1][column] != '*')) {
				queue.add(new int[] {row - 1, column});
			}
			if ((column + 1 < columnCount) && (patchArr[row][column + 1] != '*')) {
				queue.add(new int[] {row, column + 1});
			}
			if ((column - 1 > -1) && (patchArr[row][column - 1] != '*')) {
				queue.add(new int[] {row, column - 1});
			}
		}
		
		System.out.println(totalValue);
	}
}
