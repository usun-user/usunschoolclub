package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import edu.usun.schoolclub.BreadthFirstSearch.Node;

public class CodingContest4Problem6 {
	
	public static class Node {
		int x = 0;
		int y = 0;
		boolean visited = false;
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
		
		//int n = 0; //number of nodes in the graph
		
		/*
		Node node0 = new Node();
		node0.data = "0";
		Node node1 = new Node();
		node1.data = "1";
		Node node2 = new Node();
		node2.data = "2";
		Node node3 = new Node();
		node3.data = "3";
		Node node4 = new Node();
		node4.data = "4";
		
		
		node0.neighbourNodes.add(node1);
		node1.neighbourNodes.addAll(Arrays.asList(node0, node3));
		node2.neighbourNodes.addAll(Arrays.asList(node3));
		node3.neighbourNodes.addAll(Arrays.asList(node1, node2, node4));
		node4.neighbourNodes.addAll(Arrays.asList(node3));
		*/
		
		Node startNode = new Node();
		startNode.x = 0;
		startNode.y = 0;
		
		Node endNode = new Node();
		endNode.x = keyX;
		endNode.y = keyY;
		
		int[] xMovesArray = {-1, 1, 0, 0};
		int[] yMovesArray = {0, 0, 1, -1};
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode); // add startNode to back of queue
		boolean reachedEnd = false;
		
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll(); // make currentNode = node in the front of queue, add remove it from queue
			
			for (int i = 0; i < 4; i++) {
				int neighbourX = currentNode.x + xMovesArray[i];
				int neighbourY = currentNode.y + xMovesArray[i];
				
				if (neighbourX < 0 || neighbourX >= lengthOfSides) {
					continue;
				}
				if (neighbourY < 0 || neighbourY >= lengthOfSides) {
					continue;
				}
				
				Node potentialNeighbourNode = new Node();
				potentialNeighbourNode.x = neighbourX;
				potentialNeighbourNode.y = neighbourY;
				
				currentNode.neighbourNodes.add(potentialNeighbourNode);
			}
			
			if (currentNode == endNode) { // usually do .equals , but memory address did not change so we did not do this
				reachedEnd = true;
				break; // get out of while loop
			}
			
			if (currentNode.visited) {
				continue; // prevent infinite loop (caused by visiting same node again) by going back to next cycle of while loop
			}
			currentNode.visited = true;
			System.out.println("visited node: " + currentNode.x + " " + currentNode.y);
			
			queue.addAll(currentNode.neighbourNodes); // add all neighbourNodes of currentNode
		}
		
		if (reachedEnd && minimumMoves <= maxMoves) {
			System.out.println(minimumMoves);
		} else {
			System.out.println(lengthOfSides);
		}
		
		//-----------------------
		
		for (int i = 0; i < numberOfBoxes; i++) {
			
		}
		for (int i = 0; i < numberOfBoxes; i++) {
			
		}
		
		sc.close();
	}

}
