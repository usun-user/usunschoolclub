package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//import java.io.InputStreamReader;
import java.io.FileReader;

public class DMOJ_LongestCommonSubsequence {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sequenceLength1 = Integer.parseInt(st.nextToken());
		int sequenceLength2 = Integer.parseInt(st.nextToken());
		int[] sequence1 = new int[sequenceLength1];
		int[] sequence2 = new int[sequenceLength2];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < sequenceLength1; i++) {
			sequence1[i] = Integer.parseInt(st2.nextToken());
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i = 0; i < sequenceLength2; i++) {
			sequence2[i] = Integer.parseInt(st3.nextToken());
		}
		br.close();
		int[][] memo = new int[sequenceLength1][sequenceLength2];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}
		if (sequenceLength1 > sequenceLength2) {
			System.out.println(findLongestSubsequence(sequenceLength1 - 1, sequenceLength2 - 1, sequence1, sequence2, memo));
		} else {
			System.out.println(findLongestSubsequence(sequenceLength2 - 1, sequenceLength1 - 1, sequence2, sequence1, memo));
		}
	}	

	static int findLongestSubsequence(int sequenceLengthBigger, int sequenceLengthSmaller, int[] sequenceBigger, int[] sequenceSmaller, int[][] memo) {
		int smallerSequence = Math.min(sequenceLength1, sequenceLength2);
		if (smallerSequence == 0) {
			return 0;
		}
		
		if (memo[sequenceLength1][sequenceLength2] != -1) {
			return memo[sequenceLength1][sequenceLength2];
		}
		
		int currentLongest = findLongestSubsequence(sequenceLength1 - 1, sequenceLength2, sequence1, sequence2, memo);
		if (sequence1[sequenceLength1 - 1] == sequence2[sequenceLength2 - 1]) {
			currentLongest++;
		}
		
		// this is very incorrect
		for (int i = 2; i <= smallerSequence; i++) {
			int possibleNewLongest = findLongestSubsequence(sequenceLength1 - i, sequenceLength2, sequence1, sequence2, memo);
			if (sequence1[sequenceLength1 - i] == sequence2[sequenceLength2 - i]) {
				possibleNewLongest++;
			}
			currentLongest = Math.max(currentLongest, possibleNewLongest);
		}
		memo[sequenceLength1][sequenceLength2] = currentLongest;
		return currentLongest;
	}
		
		/*
		int stones = Integer.parseInt(st.nextToken());
		int maxStepSize = Integer.parseInt(st.nextToken());
		if (maxStepSize >= stones) {
			maxStepSize = stones - 1;
		}
		int[] heights = new int[stones];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < stones; i++) {
			heights[i] = Integer.parseInt(st2.nextToken());
		}
		br.close();
		// dynamic programming:
		// algorithmic technique for solving complex problems by breaking them down into simpler subproblems recursively,
		// solving each subproblem only once, and storing their solutions to avoid redundant calculations.
		// top-down approach, so memoization to store results of previous function calls.
		// bottom-up approach would have tabulation instead to store.
		int[] memo = new int[stones];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = Math.abs(heights[1] - heights[0]);
		for (int i = 2; i < maxStepSize; i++) {
			memo[i] = findBestPath(i, heights, memo, i);
		}
		System.out.println(findBestPath(stones - 1, heights, memo, maxStepSize));
	}
	
	static int findBestPath(int stones, int[] heights, int[] memo, int maxStepSize) {
		if (memo[stones] != -1) {
			return memo[stones];
		}
		int currentCost = findBestPath(stones - 1, heights, memo, maxStepSize) + Math.abs(heights[stones] - heights[stones - 1]);
		for (int i = 2; i <= maxStepSize; i++) {
			currentCost = Math.min(currentCost, 
					findBestPath(stones - i, heights, memo, maxStepSize) + Math.abs(heights[stones] - heights[stones - i]));
		}
		memo[stones] = currentCost;
		return currentCost;
	}
	*/

}
