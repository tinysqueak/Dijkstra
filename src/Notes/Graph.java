package Notes;

import java.util.*;

public class Graph {
	
	private HashMap<String, HashMap<String, Integer>> distanceMap;
	private HashMap<String, ArrayList<String>> map;
	
	//just one HashMap or both?
	//given only "A", possible to do Dijkstra using only distanceMap and not map? Yes
	
	public static void main(String[] args) {
		
		//Create map like on on board
		//A to B and C
		//B to nothing
		//C to A
		
		Graph graph = new Graph();
		graph.map = new HashMap<String, ArrayList<String>>();
		graph.distanceMap = new HashMap<String, HashMap<String, Integer>>();
		
		ArrayList<String> BC = new ArrayList<String>();
		BC.add("B");
		BC.add("C");
		
		ArrayList<String> AList = new ArrayList<String>();
		AList.add("A");
		
		graph.map.put("A", BC);
		graph.map.put("B", null);
		graph.map.put("C", AList);
		
		//What is the set of nodes connected from A
		System.out.println(graph.map.get("A"));
		
		//Set distance between two nodes that are linked
		//getDistance returns -1 if no direct path from A to B
		
		HashMap<String, Integer> nodeADistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeBDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> nodeCDistances = new HashMap<String, Integer>();
		
		//one line for each edge in graph
		nodeADistances.put("B", 3);
		nodeADistances.put("C", 1);
		
		nodeCDistances.put("A", 4);
		nodeCDistances.put("B", 1);
		
		graph.distanceMap.put("A", nodeADistances);
		graph.distanceMap.put("B", nodeBDistances);
		graph.distanceMap.put("C", nodeCDistances);
		
		//works
		System.out.println(graph.distanceMap.get("A")); //drops HashMap to adjacent nodes from "A" on the floor
		
		//how to get distances to node that is the first in getADistances? (nodeBDistances)
		HashMap<String, Integer> gotADistances = graph.distanceMap.get("A");
		
		Iterator<String> keySetIterator = gotADistances.keySet().iterator();
		System.out.println(keySetIterator.next());
		
	}
	
}

// 1.) An adjacency list representation of a graph is a collection of unordered lists, one for each vertex in the graph. Each list describes the set of neighbors of its vertex.
// 2.) Yes
// 3.) Yes