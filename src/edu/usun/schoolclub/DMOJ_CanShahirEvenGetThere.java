package edu.usun.schoolclub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DMOJ_CanShahirEvenGetThere {
	
	public static class Node {
		boolean visited = false;
		List<Node> neighbourNodes = new LinkedList<>();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberOfHouses = Integer.parseInt(st.nextToken());
		Node[] houses = new Node[numberOfHouses];
		Arrays.fill(houses, new Node());
		for (int i = 0; i < numberOfHouses; i++) {
			houses[i] = new Node();
		}
		
		int numberOfRoads = Integer.parseInt(st.nextToken());
		
		Node startNode = houses[Integer.parseInt(st.nextToken()) - 1];
		Node endNode = houses[Integer.parseInt(st.nextToken()) - 1];
		
		for (int i = 0; i < numberOfRoads; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int connectedHouse1 = Integer.parseInt(st2.nextToken()) - 1;
			int connectedHouse2 = Integer.parseInt(st2.nextToken()) - 1;
			houses[connectedHouse1].neighbourNodes.add(houses[connectedHouse2]);
			houses[connectedHouse2].neighbourNodes.add(houses[connectedHouse1]);
		}
		br.close();
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode); // add startNode to back of queue
		boolean reachedEnd = false;
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll(); // make currentNode = node in the front of queue, and remove it from queue
			if (currentNode == endNode) { // usually do .equals , but memory address did not change so we did not do this
				reachedEnd = true;
				break; // get out of while loop
			}
			if (currentNode.visited) {
				continue; // prevent infinite loop (caused by visiting same node again) by going back to next cycle of while loop
			}
			currentNode.visited = true;
			queue.addAll(currentNode.neighbourNodes); // add all neighbourNodes of currentNode
		}
		
		if (reachedEnd) {
			System.out.println("GO SHAHIR!");
		} else {
			System.out.println("NO SHAHIR!");
		}
	}

}
