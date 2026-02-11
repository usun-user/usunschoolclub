package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC25J5_ConnectingTerritories {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rowCount = Integer.parseInt(br.readLine());
		int columnCount = Integer.parseInt(br.readLine());
		int maxCost = Integer.parseInt(br.readLine());
		
		int tileCost = 1;
		int newCost = 0;
		
		int[] memo = new int[columnCount];
		for (int i = 0; i < columnCount; i++) {
			memo[i] = tileCost;
			if (tileCost == maxCost) {
				tileCost = 1;
			} else {
				tileCost++;
			}
		}
		
		for (int i = 1; i < rowCount; i++) {
			int currentCost = Math.min(memo[0], memo[1]) + tileCost;
			newCost = currentCost;
			if (tileCost == maxCost) {
				tileCost = 1;
			} else {
				tileCost++;
			}
			
			for (int j = 1; j < columnCount - 1; j++) {
				currentCost = Math.min(memo[j - 1], Math.min(memo[j], memo[j + 1])) + tileCost;
				memo[j - 1] = newCost;
				newCost = currentCost;
				if (tileCost == maxCost) {
					tileCost = 1;
				} else {
					tileCost++;
				}
			}
			
			currentCost = Math.min(memo[columnCount - 2], memo[columnCount - 1]) + tileCost;
			memo[columnCount - 2] = newCost;
			memo[columnCount - 1] = currentCost;
			if (tileCost == maxCost) {
				tileCost = 1;
			} else {
				tileCost++;
			}
		}
		
		int minCost = memo[0];
		for (int i = 1; i < columnCount; i++) {
			minCost = Math.min(minCost, memo[i]);
		}
		System.out.println(minCost);
	}
}
