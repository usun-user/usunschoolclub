package edu.usun.schoolclub;

import java.util.*;
import java.io.*;

public class CCC22J1_CupcakeParty {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int regularCount = sc.nextInt();
		int smallCount = sc.nextInt();
		int total = (regularCount * 8) + (smallCount * 3);
		
		System.out.println(total - 28);
	}
}
