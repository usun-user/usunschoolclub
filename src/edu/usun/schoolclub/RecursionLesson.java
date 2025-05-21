package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Scanner;

public class RecursionLesson {

	public static int factorial(int n) {
		// Base case
		if (n == 0 || n == 1) {
			return 1;
		}
		// Recursive case
		else {
			return n * factorial(n - 1);
		}
	}
	
	public static int fibonacci(int n) {
		// Base case
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		// Recursive case
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		// Example usage
		System.out.println(factorial(6)); // Output: 720
		System.out.println(fibonacci(8)); // Output: 21 // However is very slow
		sc.close();
	}
	
}
