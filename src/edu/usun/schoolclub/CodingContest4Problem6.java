package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class CodingContest4Problem6 {
	
	public static class Node {
		int x = 0;
		int y = 0;
		int depth = 0;
		List<Node> neighbourNodes = new LinkedList<>();
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int lengthOfSides = sc.nextInt();
		int numberOfBoxes = sc.nextInt();
		int keyX = sc.nextInt();
		int keyY = sc.nextInt();
		int maxMoves = sc.nextInt();
		int minimumMoves = 0;
		
		Node startNode = new Node();
		startNode.x = 1;
		startNode.y = 1;
		
		Node endNode = new Node();
		endNode.x = keyX;
		endNode.y = keyY;
		
		int[] xMovesArray = {-1, 1, 0, 0};
		int[] yMovesArray = {0, 0, 1, -1};
		
		boolean reachedEnd = false;
		
		for (int i = 0; i < 2; i++) {
			// "x_y"
			Set<String> visitedNodeCoords = new HashSet<>();
			Set<String> obstacleNodeCoords = new HashSet<>();
			
			Queue<Node> queue = new LinkedList<>();
			reachedEnd = false;
			queue.add(startNode);
			
			for (int j = 0; j < numberOfBoxes; j++) {
				obstacleNodeCoords.add(sc.nextInt() + "_" + sc.nextInt());
			}
			
			while (!queue.isEmpty()) {
				Node currentNode = queue.poll();
				
				if ((currentNode.x == endNode.x) && (currentNode.y == endNode.y)) {
					reachedEnd = true;
					minimumMoves += currentNode.depth;
					break;
				}
				
				if (visitedNodeCoords.contains(currentNode.x + "_" + currentNode.y)) {
					continue;
				}
				
				visitedNodeCoords.add(currentNode.x + "_" + currentNode.y);
				
				for (int j = 0; j < 4; j++) {
					int neighbourX = currentNode.x + xMovesArray[j];
					int neighbourY = currentNode.y + yMovesArray[j];
					
					if (neighbourX < 1 || neighbourX > lengthOfSides) {
						continue;
					}
					if (neighbourY < 1 || neighbourY > lengthOfSides) {
						continue;
					}
					if (obstacleNodeCoords.contains(neighbourX + "_" + neighbourY)) {
						continue;
					}
					
					Node aNeighbourNode = new Node();
					aNeighbourNode.x = neighbourX;
					aNeighbourNode.y = neighbourY;
					aNeighbourNode.depth = currentNode.depth + 1;
					
					queue.add(aNeighbourNode);
				}
			}
			
			if (!reachedEnd) {
				break;
			}
			
			startNode = new Node();
			startNode.x = endNode.x;
			startNode.y = endNode.y;
			
			endNode = new Node();
			endNode.x = lengthOfSides;
			endNode.y = lengthOfSides;
		}
		
		if (reachedEnd && minimumMoves <= maxMoves) {
			System.out.println(minimumMoves);
		} else {
			System.out.println("N");
		}
		sc.close();
	}

}
