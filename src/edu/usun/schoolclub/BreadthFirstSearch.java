package edu.usun.schoolclub;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
	
	public static class Node {
		String data; // coords in coding contest problem
		boolean visited = false;
		List<Node> neighbourNodes = new LinkedList<>();
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(
				"C:\\_igor\\eclipseworkspace\\usunschoolclub\\src\\edu\\usun\\schoolclub\\SampleReadWrite.txt"));
		int n = 0; //number of nodes in the graph
		
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
		
		Node startNode = node0;
		Node endNode = node4;
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode); // add startNode to back of queue
		boolean reachedEnd = false;
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll(); // make currentNode = node in the front of queue, add remove it from queue
			if (currentNode == endNode) { // usually do .equals , but memory address did not change so we did not do this
				reachedEnd = true;
				break; // get out of while loop
			}
			
			if (currentNode.visited) {
				continue; // prevent infinite loop (caused by visiting same node again) by going back to next cycle of while loop
			}
			currentNode.visited = true;
			System.out.println("visited node: " + currentNode.data);
			
			queue.addAll(currentNode.neighbourNodes); // add all neighbourNodes of currentNode
		}
		
		if (reachedEnd) {
			System.out.println("Reached end: " + endNode.data);
		}
		
		sc.close();
	}

}
