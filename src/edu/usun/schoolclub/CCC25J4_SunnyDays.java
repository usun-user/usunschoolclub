package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC25J4_SunnyDays {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int dayCount = sc.nextInt();
		sc.nextLine();
		
		int maxConsecutiveSunshine = 1;
		int sunshineBlock1 = 1;
		int sunshineBlock2 = 1;
		boolean isOnlySunshine = true;
		
		for (int i = 0; i < dayCount; i++) {
			String weather = sc.nextLine();
			
			if (weather.equals("S")) {
				sunshineBlock1++;
				sunshineBlock2++;
				
			} else if (weather.equals("P")) {
				isOnlySunshine = false;
				if (sunshineBlock1 >= sunshineBlock2) {
					maxConsecutiveSunshine = Math.max(maxConsecutiveSunshine, sunshineBlock1);
					sunshineBlock1 = 1;
				} else {
					maxConsecutiveSunshine = Math.max(maxConsecutiveSunshine, sunshineBlock2);
					sunshineBlock2 = 1;
				}
			}
		}
		
		if (sunshineBlock1 >= sunshineBlock2) {
			maxConsecutiveSunshine = Math.max(maxConsecutiveSunshine, sunshineBlock1);
		} else {
			maxConsecutiveSunshine = Math.max(maxConsecutiveSunshine, sunshineBlock2);
		}
		
		if (isOnlySunshine) {
			maxConsecutiveSunshine -= 2; // because minus one for no P to replace, and another minus one for one S having to be wrong
		}
		System.out.println(maxConsecutiveSunshine);
	}
}
