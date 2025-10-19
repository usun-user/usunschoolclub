package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//import java.io.InputStreamReader;

public class DMOJ_AgeDemographic {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfViewers = Integer.parseInt(br.readLine());
		int[] ages = new int[numberOfViewers];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numberOfViewers; i++) {
			ages[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ages);		
		int numberOfLines = Integer.parseInt(br.readLine());
		for (int i = 0; i < numberOfLines; i++) {
			st = new StringTokenizer(br.readLine());
			int targetLow = Integer.parseInt(st.nextToken());
			int targetHigh = Integer.parseInt(st.nextToken());
			int lowAns = 0;
			int highAns = numberOfViewers;
			if (targetHigh < ages[0]) {
				System.out.println(0);
				continue;
			} else if (targetHigh < ages[numberOfViewers - 1]) {
				int low = 0;
				int high = numberOfViewers - 1;
				while (low <= high) {
					int mid = (high + low) / 2;
					if (ages[mid] <= targetHigh) {
						low = mid + 1;
					} else {
						highAns = mid;
						high = mid - 1;
					}
				}
			}
			if (targetLow > ages[numberOfViewers - 1]) {
				System.out.println(0);
				continue;
			} else if (targetLow > ages[0]) {
				int low = 0;
				int high = highAns;
				while (low <= high) {
					int mid = (high + low) / 2;
					if (ages[mid] >= targetLow) {
						lowAns = mid;
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}
			}
			System.out.println(highAns - lowAns);
		}
		br.close();
	}

}
