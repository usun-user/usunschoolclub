package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DMOJ_SumOfPrimes2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int numberOfLines = sc.nextInt();
		for (int i = 0; i < numberOfLines; i++) {
			int minRange = sc.nextInt();
			int maxRange = sc.nextInt();
			boolean[] isPrime = new boolean[maxRange + 1];
			Arrays.fill(isPrime, true);
			isPrime[0] = false;
			isPrime[1] = false;
			
			for (int j = 2; j * j <= maxRange; j++) {
				if (isPrime[j]) {
					for (int k = j * j; k <= maxRange; k += j) {
						isPrime[k] = false;
					}
				}
			}

			int primeSum = 0;
			for (int j = minRange; j <= maxRange; j++) {
				if (isPrime[j]) {
					primeSum += j;
				}
			}
			System.out.println(primeSum);
		}
		sc.close();
	}

}
