package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DMOJ_Primes2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int minRange = sc.nextInt();
		int maxRange = sc.nextInt();
		sc.close(); // is it better to put it here instead of at the end
		
		boolean[] isPrime = new boolean[maxRange + 1]; //create boolean array to mark prime numbers up to maxRange
		Arrays.fill(isPrime, true); //assume all numbers are prime to start
		
		//0 and 1 are not primes
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i * i <= maxRange; i++) { //prime sieving to mark non-primes
			if (isPrime[i]) { //only using primes, not multiples of primes
				for (int j = i * i; j <= maxRange; j += i) {
					isPrime[j] = false; //mark all multiples of i as not prime
				}
			}
		}
		
		for (int i = minRange; i <= maxRange; i++) { //output all prime numbers from minRange to maxRange
			if (isPrime[i]) {
				System.out.println(i);
			}
		}
	}

}
