package edu.usun.schoolclub;

import java.util.*;
import java.io.*;

public class CCC22J5_SquarePool_Faster {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int gridLength = sc.nextInt();
		int treeCount = sc.nextInt();
		
		int maxLength = 1;
		
		ArrayList<int[]> trees = new ArrayList<>();
		
		// grid top boundary
		trees.add(new int[] {0, gridLength});
		// grid left boundary
		trees.add(new int[] {gridLength, 0});
		
		for (int i = 0; i < treeCount; i++) {
			trees.add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		
		// include boundaries
		treeCount += 2;
		
		for (int i = 0; i < treeCount; i++) {
			int[] topTree = trees.get(i);
			int topBoundary = topTree[0];
			int rightBoundary = topTree[1];
			
			for (int j = 0; j < treeCount; j++) {
				int[] leftTree = trees.get(j);
				int leftBoundary = leftTree[1];
				
				// if leftTree is below (higher row #) and left (lower col #) of topTree
				if ((leftTree[0] > topBoundary) && (leftBoundary < rightBoundary)) {
					// calculate pool possibilities by choosing tree pairs (and grid top and left boundary), to find biggest top-left pool
					// ----------x----
					// -O <-- square starts at top-left corner of trees (or grid boundaries) - if there is tree at square starting position, then length = 0
					// x
					// -       x <-- random tree inside area
					// -
					
					int startRow = topBoundary + 1;
					int startCol = leftBoundary + 1;
					
					int verticalLength = gridLength - topBoundary;
					int horizontalLength = gridLength - leftBoundary;
					int currentLength = Math.min(verticalLength, horizontalLength);
					
					for (int k = 0; k < treeCount; k++) {
						int[] restrictionTree = trees.get(k);
						// if restrictionTree is below topTree and right of leftTree, can limit size
						if ((restrictionTree[0] > topBoundary) && (restrictionTree[1] > leftBoundary)) {
							currentLength = Math.min(currentLength, 
									Math.max(restrictionTree[0] - startRow, restrictionTree[1] - startCol));
						}
					}
					
					maxLength = Math.max(maxLength, currentLength);
				}
			}
			
		}
		
		System.out.println(maxLength);
	}
}
