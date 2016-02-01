package Notes;

import java.util.*;

public class Dijkstra {

	//the previous node from a given node
	public HashMap<String, String> path;

	String startNode;

	//whether is minimum distance or not, selected set
	private ArrayList<Boolean> k;

	//node names
	private ArrayList<String> nodes;

	//previous node for a given node
	private ArrayList<String> pv;

	//cumulative distance from start node
	private ArrayList<Double> dv;

	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start) {

		initialize(start, nodeDistances);
		
		startNodeIndex = nodeDistances.
		
		/*
		 * need to establish relationship between nodeDistances maps and k
		 * order of nodes isn't obvious
		 * 
		 * brute force = iterate through nodeDistances until key == start, iteration number
		 * then equals start index, which index of k to set true. 
		 * 
		 * Change k to a Map?
		 */


	}

	private void initialize(String start, HashMap<String, HashMap<String, Integer>> nodeDistances) {

		this.startNode = start;
		
		initializeDv(nodeDistances.size());

		//initialize k
		initializeK(nodeDistances.size());
		//supposed to use priority queue?

		initializePv(nodeDistances.size());

	}

	private void initializeK(int kSize) {
		//for each element in k, make it false

		k = new ArrayList<Boolean>();

		for(int i = 0; i < kSize; i++) {

			k.add(false);

		}

	}

	private void initializeDv(int size) {

		dv = new ArrayList<Double>();

		for(int i = 0; i < size; i++) {

			dv.add(Double.POSITIVE_INFINITY);

		}

	}

	private void initializePv(int size) {

		pv = new ArrayList<String>();

		for(int i = 0; i < size; i++) {

			pv.add(null);

		}

	}



}
