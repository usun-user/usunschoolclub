package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//import java.io.InputStreamReader;
import java.io.FileReader;

public class DMOJ_Knapsack2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int items = Integer.parseInt(st.nextToken());
		long maxWeight = Long.parseLong(st.nextToken());
		int[] weights = new int[items];
		int[] values = new int[items];
		int maxValue = 0;
		for (int i = 0; i < items; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st2.nextToken());
			values[i] = Integer.parseInt(st2.nextToken());
			maxValue += values[i];
		}
		br.close();
		long[] dp = new long[maxValue + 1]; // dp[v] = minimum weight needed to achieve value v
		//int[] dp = new int[maxWeight + 1]; // dp[w] = max value possible within weight w
		Arrays.fill(dp, maxWeight * items);
		dp[0] = 0;
		for (int i = 0; i < items; i++) {
			for (int v = maxValue; v >= values[i]; v--) {
				dp[v] = Math.min(dp[v], dp[v - values[i]] + weights[i]);
			}
		}
		// find max value <= maxWeight
		long currentValue = 0;
		for (int v = 0; v <= maxValue; v++) {
			if (dp[v] <= maxWeight) {
				currentValue = v;
			}
		}
		System.out.println(currentValue);
	}

}
