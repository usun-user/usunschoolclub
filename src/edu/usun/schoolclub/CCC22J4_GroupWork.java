package edu.usun.schoolclub;

import java.util.*;
import java.io.*;

public class CCC22J4_GroupWork {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		HashMap<String, ArrayList<String>> togetherMap = new HashMap<>();
		
		int togetherPairCount = sc.nextInt();
		int violationCount = togetherPairCount;
		for (int i = 0; i < togetherPairCount; i++) {
			String name1 = sc.next();
			String name2 = sc.next();
			
			ArrayList<String> current = togetherMap.get(name1);
			if (current == null) {
				current = new ArrayList<>();
			}
			current.add(name2);
			togetherMap.put(name1, current);
			
			current = togetherMap.get(name2);
			if (current == null) {
				current = new ArrayList<>();
			}
			current.add(name1);
			togetherMap.put(name2, current);
		}
		
		HashMap<String, ArrayList<String>> separateMap = new HashMap<>();
		
		int separatePairCount = sc.nextInt();
		for (int i = 0; i < separatePairCount; i++) {
			String name1 = sc.next();
			String name2 = sc.next();
			
			ArrayList<String> current = separateMap.get(name1);
			if (current == null) {
				current = new ArrayList<>();
			}
			current.add(name2);
			separateMap.put(name1, current);
			
			current = separateMap.get(name2);
			if (current == null) {
				current = new ArrayList<>();
			}
			current.add(name1);
			separateMap.put(name2, current);
		}
		
		int groupCount = sc.nextInt();
		for (int i = 0; i < groupCount; i++) {
			String name1 = sc.next();
			String name2 = sc.next();
			String name3 = sc.next();
			
			ArrayList<String> current = togetherMap.get(name1);
			if (current != null && current.contains(name2)) {
				violationCount--;
			}
			if (current != null && current.contains(name3)) {
				violationCount--;
			}
			current = togetherMap.get(name2);
			if (current != null && current.contains(name3)) {
				violationCount--;
			}
			
			current = separateMap.get(name1);
			if (current != null && current.contains(name2)) {
				violationCount++;
			}
			if (current != null && current.contains(name3)) {
				violationCount++;
			}
			current = separateMap.get(name2);
			if (current != null && current.contains(name3)) {
				violationCount++;
			}
		}
		
		System.out.println(violationCount);
	}
}
