package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC23J1_Delivedroid {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int packageCount = sc.nextInt();
		int collisionCount = sc.nextInt();
		int score = (packageCount * 50) - (collisionCount * 10);
		if (packageCount > collisionCount) {
			score += 500;
		}
		System.out.println(score);
	}
}
