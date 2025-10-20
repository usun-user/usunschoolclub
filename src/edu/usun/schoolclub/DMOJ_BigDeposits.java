package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
//import java.io.InputStreamReader;

public class DMOJ_BigDeposits {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//double percent = 1 + (Integer.parseInt(st.nextToken()) / (double) 100);
		int percentNumerator = Integer.parseInt(st.nextToken()) + 100;
		int years = Integer.parseInt(st.nextToken());
		long total = Long.parseLong(st.nextToken());
		
		long low = 1;
		long high = Math.ceilDiv(total, years); // worst case scenario
		long ans = 1;
		
		outerLoop:
		while (low <= high) {
			long mid = (high + low) / 2;
			long amount = 0;
			for (int i = 0; i < years; i++) {
				//amount = (long) Math.floor((amount + mid) * percent);
				amount = ((amount + mid) * percentNumerator) / 100; 
				// Math.floor() not needed because division already rounds down
				if (amount >= total) {
					ans = mid;
					high = mid - 1;
					continue outerLoop;
				} 
			}
			low = mid + 1;
		}
		
		System.out.println(ans);
		br.close();
	}

}
