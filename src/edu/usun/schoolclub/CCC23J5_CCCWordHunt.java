package edu.usun.schoolclub;

import java.io.*;
import java.util.*;

public class CCC23J5_CCCWordHunt {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		char firstLetter = word.charAt(0);
		char secondLetter = word.charAt(1);
		
		int rowCount = sc.nextInt();
		int columnCount = sc.nextInt();
		
		int wordCount = 0;
		
		char[][] grid = new char[rowCount][columnCount];
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				grid[i][j] = sc.next().charAt(0);
			}
		}
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if (grid[i][j] == firstLetter) {
					//boolean canGoUp = (i - 1 >= 0);
					//boolean canGoDown = (i + 1 < rowCount);
					boolean canGoLeft = (j - 1 >= 0);
					boolean canGoRight = (j + 1 < columnCount);
					
					//0, 1, 2
					if (i - 1 >= 0) {
						//0
						if (canGoLeft && (grid[i - 1][j - 1] == secondLetter)) {
							wordCount += FindWord(grid, -1, -1, false, 0, i, j, word, true, rowCount, columnCount);
						}
						//1
						if (grid[i - 1][j] == secondLetter) {
							wordCount += FindWord(grid, -1, 0, false, 0, i, j, word, false, rowCount, columnCount);
						}
						//2
						if (canGoRight && (grid[i - 1][j + 1] == secondLetter)) {
							wordCount += FindWord(grid, -1, 1, false, 0, i, j, word, true, rowCount, columnCount);
						}
					}
					
					//7
					if (canGoLeft && (grid[i][j - 1] == secondLetter)) {
						wordCount += FindWord(grid, 0, -1, false, 0, i, j, word, false, rowCount, columnCount);
					}
					//3
					if (canGoRight && (grid[i][j + 1] == secondLetter)) {
						wordCount += FindWord(grid, 0, 1, false, 0, i, j, word, false, rowCount, columnCount);
					}
					
					//6, 5, 4
					if (i + 1 < rowCount) {
						//6
						if (canGoLeft && (grid[i + 1][j - 1] == secondLetter)) {
							wordCount += FindWord(grid, 1, -1, false, 0, i, j, word, true, rowCount, columnCount);
						}
						//5
						if (grid[i + 1][j] == secondLetter) {
							wordCount += FindWord(grid, 1, 0, false, 0, i, j, word, false, rowCount, columnCount);
						}
						//4
						if (canGoRight && (grid[i + 1][j + 1] == secondLetter)) {
							wordCount += FindWord(grid, 1, 1, false, 0, i, j, word, true, rowCount, columnCount);
						}
					}
				}
			}
		}
		
		System.out.println(wordCount);
	}
	
	// directions:
	// 0 1 2
	// 7 X 3
	// 6 5 4
	
	public static int FindWord(char[][] grid, int rowChange, int columnChange, 
			boolean isBent, int letterIndex, int i, int j, String word, boolean isDiagonal, int rowCount, int columnCount) {
		if (letterIndex + 1 == word.length()) {
			return 1;
		}
		
		int currentWordCount = 0;
		int nextLetterIndex = letterIndex + 1;
		int newRow = i + rowChange;
		int newColumn = j + columnChange;
		
		boolean canGoUp = (i - 1 >= 0);
		boolean canGoDown = (i + 1 < rowCount);
		boolean canGoLeft = (j - 1 >= 0);
		boolean canGoRight = (j + 1 < columnCount);
		char secondLetter = word.charAt(nextLetterIndex);
		
		if ((newRow >= 0) && (newRow < rowCount) && (newColumn >= 0) && (newColumn < columnCount) && (grid[newRow][newColumn] == secondLetter)) {
			currentWordCount = FindWord(grid, rowChange, columnChange, isBent, nextLetterIndex, newRow, newColumn, word, isDiagonal, rowCount, columnCount);
		}
		
		if ((!isBent) && (letterIndex != 0)) {
			if (isDiagonal) {
				//0, 2
				if (canGoUp) {
					//0
					if (((rowChange != -1) || (columnChange != -1)) && canGoLeft && (grid[i - 1][j - 1] == secondLetter)) {
						currentWordCount += FindWord(grid, -1, -1, true, nextLetterIndex, i - 1, j - 1, word, isDiagonal, rowCount, columnCount);
					}
					
					//2
					if (((rowChange != -1) || (columnChange != 1)) && canGoRight && (grid[i - 1][j + 1] == secondLetter)) {
						currentWordCount += FindWord(grid, -1, 1, true, nextLetterIndex, i - 1, j + 1, word, isDiagonal, rowCount, columnCount);
					}
				}
				
				//6, 4
				if (canGoDown) {
					//6
					if (((rowChange != 1) || (columnChange != -1)) && canGoLeft && (grid[i + 1][j - 1] == secondLetter)) {
						currentWordCount += FindWord(grid, 1, -1, true, nextLetterIndex, i + 1, j - 1, word, isDiagonal, rowCount, columnCount);
					}
					
					//4
					if (((rowChange != 1) || (columnChange != 1)) && canGoRight && (grid[i + 1][j + 1] == secondLetter)) {
						currentWordCount += FindWord(grid, 1, 1, true, nextLetterIndex, i + 1, j + 1, word, isDiagonal, rowCount, columnCount);
					}
				}
				
			} else {
				//1
				if (((rowChange != -1) || (columnChange != 0)) && canGoUp && (grid[i - 1][j] == secondLetter)) {
					currentWordCount += FindWord(grid, -1, 0, true, nextLetterIndex, i - 1, j, word, isDiagonal, rowCount, columnCount);
				}
				//3
				if (((rowChange != 0) || (columnChange != 1)) && canGoRight && (grid[i][j + 1] == secondLetter)) {
					currentWordCount += FindWord(grid, 0, 1, true, nextLetterIndex, i, j + 1, word, isDiagonal, rowCount, columnCount);
				}
				//5
				if (((rowChange != 1) || (columnChange != 0)) && canGoDown && (grid[i + 1][j] == secondLetter)) {
					currentWordCount += FindWord(grid, 1, 0, true, nextLetterIndex, i + 1, j, word, isDiagonal, rowCount, columnCount);
				}
				//7
				if (((rowChange != 0) || (columnChange != -1)) && canGoLeft && (grid[i][j - 1] == secondLetter)) {
					currentWordCount += FindWord(grid, 0, -1, true, nextLetterIndex, i, j - 1, word, isDiagonal, rowCount, columnCount);
				}
			}
		}
		
		return currentWordCount;
	}
}
