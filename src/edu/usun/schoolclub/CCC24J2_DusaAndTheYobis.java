package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC24J2_DusaAndTheYobis {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		while (true) {
			int monster = sc.nextInt();
			if (size > monster) {
				size += monster;
			} else {
				System.out.println(size);
				return;
			}
		}
	}
}
