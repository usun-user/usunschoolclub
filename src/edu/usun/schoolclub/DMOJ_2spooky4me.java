package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.HashMap;
//import java.io.InputStreamReader;

public class DMOJ_2spooky4me {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		short decorations = Short.parseShort(st.nextToken());
		int houses = Integer.parseInt(st.nextToken());
		int maxSpookiness = Integer.parseInt(st.nextToken());
		
		String[] originalValues = new String[decorations];
		
		// coordinate compression
		
		TreeSet<Integer> uniqueCoords = new TreeSet<>();
		for (int i = 0; i < decorations; i++) {
			String inputLine = br.readLine();
			StringTokenizer st2 = new StringTokenizer(inputLine);
			originalValues[i] = inputLine;
			uniqueCoords.add(Integer.parseInt(st2.nextToken()));
			uniqueCoords.add(Integer.parseInt(st2.nextToken()) + 1);
		}
		
		HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
		HashMap<Integer, Integer> indexToValueMap = new HashMap<>();
		
		int loopCount = 0;
		for (Integer i : uniqueCoords) {
			valueToIndexMap.put(i, loopCount);
			indexToValueMap.put(loopCount, i);
			loopCount++;
		}
		
		int mapSize = valueToIndexMap.size();
		int[] diffArr = new int[mapSize + 1];
		for (String i : originalValues) {
			StringTokenizer st3 = new StringTokenizer(i);
			int lowRange = valueToIndexMap.get(Integer.parseInt(st3.nextToken()));
			int highRange = valueToIndexMap.get(Integer.parseInt(st3.nextToken()) + 1);
			int addedSpookiness = Integer.parseInt(st3.nextToken());
			diffArr[lowRange] += addedSpookiness;
			diffArr[highRange] -= addedSpookiness;
		}
		
		int candies = indexToValueMap.get(0) - 1;
		int currentSpookiness = 0;
		for (int i = 0; i < mapSize; i++) {
			currentSpookiness += diffArr[i];
			if (currentSpookiness < maxSpookiness) {
				if (indexToValueMap.get(i + 1) == null) {
					candies += houses - indexToValueMap.get(i) + 1;
				} else {
					candies += indexToValueMap.get(i + 1) - indexToValueMap.get(i);
				}
			}
		}
		System.out.println(candies);
		br.close();
	}

}
