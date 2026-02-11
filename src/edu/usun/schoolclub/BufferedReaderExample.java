package edu.usun.schoolclub;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
//import java.io.InputStreamReader;

public class BufferedReaderExample {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		
		// https://dmoj.ca/tips/
		
		//REMEMBER TO PUT " throws Exception " after " public static void main(String[] args) " when using BufferedReader
		//but better to always to put throws exception on the websites
		
		//On websites like DMOJ, do what is below instead of the above while also importing java.io.InputStreamReader: 
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//java BufferedReader is 100x faster than Scanner class, especially for large inputs (ex. 10^5 lines is a lot)
		//use BufferedReader whenever speed matters instead of sc.nextInt(); or sc.nextLine();
		
		/* Note from DMOJ website: the underlying input stream is not a file stream, 
		so polling methods like BufferedReader.ready might spuriously return false 
		even if the end of the input has not been reached. */
		
		int stations = Integer.parseInt(br.readLine());
		int minTroops = Integer.parseInt(br.readLine());
		int waves = Integer.parseInt(br.readLine());
		int[] diffArr = new int[stations + 1];
		for (int i = 0; i < waves; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int lowRange = Integer.parseInt(st.nextToken());
			int highRange = Integer.parseInt(st.nextToken());
			int troops = Integer.parseInt(st.nextToken());
			diffArr[lowRange - 1] += troops;
			diffArr[highRange] -= troops;
		}
		int stationsUnderMin = 0;
		int currentTroops = 0;
		for (int i = 0; i < stations; i++) {
			currentTroops += diffArr[i];
			if (currentTroops < minTroops) {
				stationsUnderMin++;
			}
		}
		System.out.println(stationsUnderMin);
		br.close();
		
		/*
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int stations = sc.nextInt();
		int minTroops = sc.nextInt();
		int waves = sc.nextInt();
		int[] diffArr = new int[stations + 1];
		for (int i = 0; i < waves; i++) {
			int lowRange = sc.nextInt();
			int highRange = sc.nextInt();
			int troops = sc.nextInt();
			diffArr[lowRange - 1] += troops;
			diffArr[highRange] -= troops;
		}
		int stationsUnderMin = 0;
		int currentTroops = 0;
		for (int i = 0; i < stations; i++) {
			currentTroops += diffArr[i];
			if (currentTroops < minTroops) {
				stationsUnderMin++;
			}
		}
		System.out.println(stationsUnderMin);
		sc.close();
		*/
	}

}
