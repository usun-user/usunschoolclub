package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class GW_PCPartPicking {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		byte numberOfLines = sc.nextByte();
		double path = 0d;
		byte currentX = 0;
		byte currentY = 0;
		HashMap<Byte, Byte> coordMap = new HashMap<>();
		for (byte i = 0; i < numberOfLines; i++) {
			coordMap.put(sc.nextByte(), sc.nextByte());
		}
		for (byte i = 1; i < 100 && numberOfLines > 0; i++) {
			if (coordMap.containsKey(i)) {
				byte oldX = currentX;
				byte oldY = currentY;
				currentX = i;
				currentY = coordMap.get(i);
				byte a = (byte)(currentX - oldX);
				byte b = (byte)(currentY - oldY);
				path += Math.sqrt((a * a) + (b * b));
				numberOfLines--;
			}
		}
		byte a = (byte)(100 - currentX);
		byte b = (byte)(100 - currentY);
		path += Math.sqrt((a * a) + (b * b));
		System.out.println((int)(path));
		sc.close();
	}

}