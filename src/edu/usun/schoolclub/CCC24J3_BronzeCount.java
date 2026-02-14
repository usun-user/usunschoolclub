package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC24J3_BronzeCount {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int participantCount = sc.nextInt();
		int goldLevel = -1;
		int silverLevel = -1;
		int bronzeLevel = -1;
		int goldCount = 0;
		int silverCount = 0;
		int bronzeCount = 0;
		
		for (int i = 0; i < participantCount; i++) {
			int score = sc.nextInt();
			if (score > goldLevel) {
				bronzeLevel = silverLevel;
				silverLevel = goldLevel;
				goldLevel = score;
				bronzeCount = silverCount;
				silverCount = goldCount;
				goldCount = 1;
			} else if (score == goldLevel) {
				goldCount++;
			} else if (score > silverLevel) {
				bronzeLevel = silverLevel;
				silverLevel = score;
				bronzeCount = silverCount;
				silverCount = 1;
			} else if (score == silverLevel) {
				silverCount++;
			} else if (score > bronzeLevel) {
				bronzeLevel = score;
				bronzeCount = 1;
			} else if (score == bronzeLevel) {
				bronzeCount++;
			}
		}
		
		System.out.println(bronzeLevel + " " + bronzeCount);
	}
}
