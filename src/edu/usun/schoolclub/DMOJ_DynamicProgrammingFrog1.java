package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//import java.io.InputStreamReader;
import java.io.FileReader;

public class DMOJ_DynamicProgrammingFrog1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int stones = Integer.parseInt(br.readLine());
		int[] heights = new int[stones];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < stones; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
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
		System.out.println(findBestPath(stones - 1, heights, memo));
	}
	
	static int findBestPath(int stones, int[] heights, int[] memo) {
		if (memo[stones] != -1) {
			return memo[stones];
		}
		memo[stones] = Math.min(findBestPath(stones - 1, heights, memo) + Math.abs(heights[stones] - heights[stones - 1]), 
				findBestPath(stones - 2, heights, memo) + Math.abs(heights[stones] - heights[stones - 2]));
		return memo[stones];
	}

}
