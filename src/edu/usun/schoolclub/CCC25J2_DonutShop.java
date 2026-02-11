package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC25J2_DonutShop {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int donutCount = sc.nextInt();
		int eventCount = sc.nextInt() * 2;
		
		for (int i = 0; i < eventCount; i++) {
			String symbol = sc.nextLine();
			if (symbol.equals("+")) {
				donutCount += sc.nextInt();
			} else if (symbol.equals("-")) {
				donutCount -= sc.nextInt();
			}
		}
		System.out.println(donutCount);
	}
}
