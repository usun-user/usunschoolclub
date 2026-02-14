package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC24J4_TroublesomeKeys {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String keysPressed = sc.nextLine();
		String keysDisplayed = sc.nextLine();
		
		char sillyKeyPressed = '-';
		char sillyKeyDisplayed = '-';
		char quietKeyPressed = '-';
		
		int pressedLength = keysPressed.length();
		int displayedLength = keysDisplayed.length();
		
		char previousPressed = '-';
		char previousDisplayed = '-';
		
		boolean pastMismatched = false;
		int offset = 0;
		int currentOffset = 0;
		
		for (int i = 0; i < pressedLength; i++) {
			char currentPressed = keysPressed.charAt(i);
			if (i - offset >= displayedLength) {
				quietKeyPressed = currentPressed;
				break;
			}
			char currentDisplayed = keysDisplayed.charAt(i - offset);
			
			if (pastMismatched) {
				if (currentPressed == previousPressed) {
					offset++;
					currentOffset++;
				} else if (currentPressed == currentDisplayed) {
					quietKeyPressed = previousPressed;
					currentOffset = 0;
					pastMismatched = false;
				} else {
					sillyKeyPressed = previousPressed;
					sillyKeyDisplayed = previousDisplayed;
					offset -= currentOffset;
					currentOffset = 0;
					previousPressed = currentPressed;
					previousDisplayed = keysDisplayed.charAt(i - offset);
					pastMismatched = false;
					continue;
				}
			} else {
				if (currentPressed == currentDisplayed) {
					pastMismatched = false;
				} else {
					if (sillyKeyPressed != '-') {
						if (currentPressed != sillyKeyPressed) {
							quietKeyPressed = currentPressed;
							break;
						}
					} else if (quietKeyPressed != '-') {
						if (currentPressed != quietKeyPressed) {
							sillyKeyPressed = currentPressed;
							sillyKeyDisplayed = currentDisplayed;
							break;
						} else {
							offset++;
						}
					} else {
						offset++;
						currentOffset++;
						pastMismatched = true;
					}
				}
			}
			
			previousPressed = currentPressed;
			previousDisplayed = currentDisplayed;
		}
		
		if (sillyKeyPressed == '-') {
			sillyKeyPressed = previousPressed;
			sillyKeyDisplayed = previousDisplayed;
		}
		
		System.out.println(sillyKeyPressed + " " + sillyKeyDisplayed);
		System.out.println(quietKeyPressed);
	}
}
