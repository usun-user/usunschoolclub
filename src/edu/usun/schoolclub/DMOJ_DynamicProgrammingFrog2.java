package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//import java.io.InputStreamReader;
import java.io.FileReader;

public class DMOJ_DynamicProgrammingFrog2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
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

}
