package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.util.StringTokenizer;
//import java.io.InputStreamReader;
import java.io.FileReader;

public class DMOJ_Knapsack1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int items = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());
		int[] weights = new int[items];
		int[] values = new int[items];
		for (int i = 0; i < items; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st2.nextToken());
			values[i] = Integer.parseInt(st2.nextToken());
		}
		br.close();
		// bottom-up dynamic programming (tabulation)
		// more efficient for time and space
		long[] dp = new long[maxWeight + 1]; // max value possible within maxWeight
		for (int i = 1; i < items; i++) {
			// starting from maxWeight column for each row (which count up by how many items there are) 
			// so that previous computations of i-1 items are not overridden
			for (int j = maxWeight; j >= weights[i - 1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
			}
		}
		// don't need to calculate any weight less than maxWeight for last item because maxWeight will always have max value
		if (maxWeight >= weights[items - 1]) {
			System.out.println(Math.max(dp[maxWeight], dp[maxWeight - weights[items - 1]] + values[items - 1]));
		}
		else {
			System.out.println(dp[maxWeight]);
		}
	}
		
	// below is less efficient, but easier, top-down dynamic programming (memoization)
	/*	
		long[][] memo = new long[items + 1][maxWeight + 1];
		for (long[] row : memo) {
			Arrays.fill(row, -1);
		}
		System.out.println(findMaxValue(items, maxWeight, weights, values, memo));
	}
	
	static long findMaxValue(int items, int maxWeight, int[] weights, int[] values, long[][] memo) {
		if (items == 0 || maxWeight == 0) {
			return 0;
		}
		if (memo[items][maxWeight] != -1) {
			return memo[items][maxWeight];
		}
		
		if (weights[items - 1] > maxWeight) {
			return memo[items][maxWeight] = findMaxValue(items - 1, maxWeight, weights, values, memo);
		}
		return memo[items][maxWeight] = Math.max(values[items - 1] + findMaxValue(items - 1, maxWeight - weights[items - 1], 
				weights, values, memo), findMaxValue(items - 1, maxWeight, weights, values, memo));
	}
	*/

}
