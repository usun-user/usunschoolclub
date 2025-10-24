package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
//import java.io.InputStreamReader;

public class DMOJ_Primes2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		// memory max is 32M, meaning 32,000,000 bytes or booleans (every boolean is 1 byte)
		// high max is 1,000,000,000 which is one billion
		// sqrt of one billion (rounded up) is 31,623 (bytes)
		
		// following algorithm is called segmented sieve of eratosthenes
		// used for finding primes within specific range
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int minRange = Integer.parseInt(st.nextToken());
		int maxRange = Integer.parseInt(st.nextToken());
		br.close();
		
		// find primes in range [2, sqrt(maxRange)] using simple sieve of eratosthenes
		int limit = (int) Math.ceil(Math.sqrt(maxRange));
		ArrayList<Integer> segmentedSieve = new ArrayList<>();
		
		boolean[] simpleSieve = new boolean[limit + 1];
		Arrays.fill(simpleSieve, true);
		for (int i = 2; i * i <= limit; i++) {
			if (simpleSieve[i]) {
				for (int j = i * i; j <= limit; j += i) {
					simpleSieve[j] = false;
				}
			}
		}
		for (int i = 2; i <= limit; i++) {
			if (simpleSieve[i]) {
				// store these primes
				segmentedSieve.add(i);
			}
		}
		
		// use stored primes to mark their multiples in range as false
		// thus, will be left with only primes in range marked as true
		boolean[] primesInRange = new boolean[maxRange - minRange + 1];
		Arrays.fill(primesInRange, true);
		
		// for (int i : segmentedSieve) { ... }
		// IS THE SAME AS
		// for (int j = 0; j < segmentedSieve.size(); j++) { 
		// int i = segmentedSieve.get(j) ... }
		
		for (int i : segmentedSieve) {
			int low = minRange / i;
			if (low <= 1) {
				low = i + i;
			} else if (minRange % i != 0) {
				low = (low * i) + i;
			} else {
				low = low * i;
			}
			// low now equals first multiple of prime in [minRange, maxRange]
			
			for (int j = low; j <= maxRange; j += i) {
				primesInRange[j - minRange] = false;
			}
		}
		
		if (minRange == 1) {
			primesInRange[0] = false;
		}
		
		for (int i = minRange; i <= maxRange; i++) {
			if (primesInRange[i - minRange]) {
				System.out.println(i);
			}
		}
	}

}
