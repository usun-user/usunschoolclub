package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC25J1_RollerCoasterRide {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int placeInLine = sc.nextInt();
		int numberOfCars = sc.nextInt();
		int peoplePerCar = sc.nextInt();
		
		if (placeInLine > numberOfCars * peoplePerCar) {
			System.out.println("no");
		} else {
			System.out.println("yes");
		}
	}
}
