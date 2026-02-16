package edu.usun.schoolclub;

import java.util.*;
import java.io.*;

public class CCC22J2_FergusonballRatings {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int playerCount = sc.nextInt();
		int goodCount = 0;
		
		for (int i = 0; i < playerCount; i++) {
			int pointCount = sc.nextInt();
			int foulCount = sc.nextInt();
			
			if ((pointCount * 5) - (foulCount * 3) > 40) {
				goodCount++;
			}
		}
		
		if (goodCount == playerCount) {
			System.out.println(goodCount + "+");
		} else {
			System.out.println(goodCount);
		}
	}
}
