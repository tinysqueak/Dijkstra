package Notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


// This is half baked code but it gives you some working code that works with Hashmaps
// like are required in the Dijkstra's algorithm assignment...

public class Graph2 {

	private HashMap<String, ArrayList<String>> adjacencies;
	private HashMap<String, HashMap<String, Integer>> nodeDistances;
	
	public static void main(String[] args) {
		// Create a graph like on the board:
		// A to b and c
		// B to nothinb
		// c to a.
		Graph2 threeNodes = new Graph2();
		threeNodes.nodeDistances = new HashMap<String, HashMap<String, Integer>>();
		threeNodes.adjacencies = new HashMap<String, ArrayList<String>>();
		ArrayList<String> BC = new ArrayList<String>();
		BC.add("B");
		BC.add("C");
		ArrayList<String> AList = new ArrayList<String>();
		AList.add("A");
		threeNodes.adjacencies.put("A", BC);
		threeNodes.adjacencies.put("B", null);
		threeNodes.adjacencies.put("C", AList);
		// What is the set of nodes connected from A?
		
		//System.out.println(threeNodes.adjacencies.get("A"));
		// we would like to be able to set the distance between two nodes 
		// that are linked....
		HashMap<String, Integer> nodeAdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeBdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeCdistances = new HashMap<String,Integer>();
		nodeAdistances.put("B",  3);
		nodeAdistances.put("C",  1);
		nodeCdistances.put("B",  1);
		nodeCdistances.put("A",  4);
	    threeNodes.nodeDistances.put("A", nodeAdistances);
	    threeNodes.nodeDistances.put("B", nodeBdistances);
	    threeNodes.nodeDistances.put("C", nodeCdistances);
	    
	    // suppose we are just given "A" can we do Dijkstra using only nodeDistances
	    // and not adjacencies (I think yes)
	    
	    HashMap<String, Integer> gotAdistances = threeNodes.nodeDistances.get("A");
	    
	    System.out.println(threeNodes.nodeDistances.get("A")); // this drops the hashmap to adjacent nodes for A on the floor
		
		
	    // but how do I get the distance to the node that is the first node 
	    // in gotAdistances???? (nodeBdistances)
	    
	    Iterator<String> keysetiterator = gotAdistances.keySet().iterator();
	    
	    System.out.println(keysetiterator.next());
	    
		// getDistance returns -1 if there is no *direct* link from "A" to "B"
		
		
		
		//System.out.println(threeNodes.myGraph.getDistance("A", "B"));
		
		

	}

}
