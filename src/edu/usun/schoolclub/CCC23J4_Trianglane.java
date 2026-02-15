package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC23J4_Trianglane {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int columnCount = sc.nextInt() + 1;
		boolean[] firstRow = new boolean[columnCount];
		boolean isPreviousWet = false;
		
		int edgeLength = 0;
		
		for (int i = 1; i < columnCount; i++) {
			int tile = sc.nextInt();
			if (tile == 1) {
				if (isPreviousWet) {
					edgeLength -= 2;
				}
				edgeLength += 3;
				firstRow[i] = true;
				isPreviousWet = true;
			} else {
				firstRow[i] = false;
				isPreviousWet = false;
			}
		}
		
		isPreviousWet = false;
		for (int i = 1; i < columnCount; i++) {
			int tile = sc.nextInt();
			if (tile == 1) {
				if (isPreviousWet) {
					edgeLength -= 2;
				}
				if (firstRow[i] && (i % 2 == 1)) {
					edgeLength -= 2;
				}
				edgeLength += 3;
				isPreviousWet = true;
			} else {
				isPreviousWet = false;
			}
		}
		
		System.out.println(edgeLength);
	}
}
