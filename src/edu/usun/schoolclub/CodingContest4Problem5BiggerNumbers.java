package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class CodingContest4Problem5BiggerNumbers {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		BigDecimal timeMax = sc.nextBigDecimal();
		int dataPoints = sc.nextInt();
		BigDecimal dataPointsBigFormat = new BigDecimal(dataPoints);
		int lines = sc.nextInt();
		BigDecimal totalChanges = new BigDecimal(0);
		for (int i = 0; i < lines; i++) {
			BigDecimal changes = sc.nextBigDecimal().multiply(dataPointsBigFormat);
			for (int j = 0; j < dataPoints; j++) {
				changes = changes.subtract(sc.nextBigDecimal());
			}
			
			totalChanges = totalChanges.add(changes.abs());
		}
		BigDecimal timeMaxInMinutes = timeMax.multiply(new BigDecimal(60));
		BigDecimal difference = timeMaxInMinutes.subtract(totalChanges);
		if (difference.signum() >= 0) {
			System.out.println(totalChanges);
		} else {
			System.out.println(timeMax);
		}
		sc.close();
	}

}
