package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class DMOJ_FloorPlan {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rowCount = Integer.parseInt(br.readLine());
		int columnCount = Integer.parseInt(br.readLine());
		
		char[][] floorArr = new char[rowCount][columnCount];
		int[] areaArr = new int[5];
		int[] startRowArr = new int[5];
		int[] startColumnArr = new int[5];
		
		for (int i = 0; i < rowCount; i++) {
			String currentRow = br.readLine();
			for (int j = 0; j < columnCount; j++) {
				char currentChar = currentRow.charAt(j);
				floorArr[i][j] = currentChar;
				if (Character.isDigit(currentChar)) {
					startRowArr[Character.getNumericValue(currentChar) - 1] = i;
					startColumnArr[Character.getNumericValue(currentChar) - 1] = j;
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<>(); 
		
		for (int i = 0; i < 5; i++) {
			int startRow = startRowArr[i];
			int startColumn = startColumnArr[i];
			queue.add(new int[] {startRow, startColumn});
			while (!queue.isEmpty()) {
				int[] position = queue.poll();
				int row = position[0];
				int column = position[1];
				
				if (floorArr[row][column] == '#') {
					continue;
				} else {
					areaArr[i]++;
				}
				
				floorArr[row][column] = '#';
				
				if ((row + 1 < rowCount) && (floorArr[row + 1][column] != '#')) {
					queue.add(new int[] {row + 1, column});
				}
				if ((row - 1 > -1) && (floorArr[row - 1][column] != '#')) {
					queue.add(new int[] {row - 1, column});
				}
				if ((column + 1 < columnCount) && (floorArr[row][column + 1] != '#')) {
					queue.add(new int[] {row, column + 1});
				}
				if ((column - 1 > -1) && (floorArr[row][column - 1] != '#')) {
					queue.add(new int[] {row, column - 1});
				}
			}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(areaArr[i]);
		}
		
		br.close();
	}
}
