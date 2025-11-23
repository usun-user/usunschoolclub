package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.util.Arrays;
//import java.io.InputStreamReader;
import java.io.FileReader;

public class CCC00S4_Golf {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		short totalDistance = Short.parseShort(br.readLine());
		byte clubs = Byte.parseByte(br.readLine());
		byte[] clubDistances = new byte[clubs];
		for (int i = 0; i < clubs; i++) {
			clubDistances[i] = Byte.parseByte(br.readLine());
		}
		br.close();
		short[] memo = new short[totalDistance + 1];
		Arrays.fill(memo, (short) -1);
		memo[0] = 0;
		for (byte distance : clubDistances) {
			memo[distance] = 1;
		}
		short minStrokes = findMinStrokes(totalDistance, clubDistances, memo, clubs);
		if (minStrokes >= 10000) {
			System.out.println("Roberta acknowledges defeat.");
		} else {
			System.out.println("Roberta wins in " + minStrokes + " strokes.");
		}
	}
	
	static short findMinStrokes(short totalDistance, byte[] clubDistances, short[] memo, byte clubs) {
		if (totalDistance < 0) {
			return 10000;
		}
		if (memo[totalDistance] != -1) {
			return memo[totalDistance];
		}
		short currentStrokes = findMinStrokes((short) (totalDistance - clubDistances[0]), clubDistances, memo, clubs);
		for (int i = 1; i < clubs; i++) {
			currentStrokes = (short) Math.min(currentStrokes, 
					findMinStrokes((short) (totalDistance - clubDistances[i]), clubDistances, memo, clubs));
		}
		currentStrokes++;
		memo[totalDistance] = currentStrokes;
		return currentStrokes;
	}

}
