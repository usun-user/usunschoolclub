package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//import java.io.InputStreamReader;

public class DMOJ_SumOfPrimes2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		// sieve of eratosthenes 
		boolean[] isPrime = new boolean[100001]; //create boolean array to mark prime numbers up to maxRange
		Arrays.fill(isPrime, true); //assume all numbers are prime to start
		isPrime[1] = false;
		for (int i = 2; i * i < 100001; i++) { //prime sieving to mark non-primes
			if (isPrime[i]) { //only using primes, not multiples of primes
				for (int j = i * i; j < 100001; j += i) {
					isPrime[j] = false; //mark all multiples of i as not prime
				}
			}
		}
		
		int[] prefixSum = new int[100001];
		prefixSum[1] = 0;
		for (int i = 2; i < 100001; i++) {
			prefixSum[i] = prefixSum[i - 1];
			if (isPrime[i]) {
				prefixSum[i] += i;
			}
		}
		
		int queries = Integer.parseInt(br.readLine());
		for (int i = 0; i < queries; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int lowRange = Integer.parseInt(st.nextToken());
			int highRange = Integer.parseInt(st.nextToken());
			System.out.println(prefixSum[highRange] - prefixSum[lowRange - 1]);
		}
		br.close();
		
		/*
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
		*/
	}

}
