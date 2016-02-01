package Notes;

import java.util.*;

public class Dijkstra implements Next {

	//shortest path
	public HashMap<String, String> path;

	String startNode;

	//whether is minimum distance or not, selected set
	private ArrayList<Boolean> k;

	private HashMap<String, Boolean> kMap;
	
	//node names
	private ArrayList<String> nodes;

	//previous node for a given node
	private ArrayList<String> pv;

	//cumulative distance from start node
	private ArrayList<Double> dv;
	
	private int startNodeIndex;

	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start) {

		initialize(start, nodeDistances);
		
		/*Iterator<String> iterator = nodeDistances.keySet().iterator();
		
		for(int i = 0; i < nodeDistances.size(); i++) {
			
			if(start.equals(iterator.next())) {
				
				startNodeIndex = i;
				break;
				
			}
			
		}*/
		//int startNodeIndex = nodeDistances.
		
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

		initializekMap(nodeDistances);
		
		initializePv(nodeDistances.size());
		

	}

	private void initializeK(int kSize) {
		//for each element in k, make it false

		k = new ArrayList<Boolean>();

		for(int i = 0; i < kSize; i++) {

			k.add(false);

		}

	}
	
	private void initializekMap(HashMap<String, HashMap<String, Integer>> nodeDistances) {
		
		kMap = new HashMap<String, Boolean>();
		
		Iterator<String> iterator = nodeDistances.keySet().iterator();
		
		while(iterator.hasNext()) {
			kMap.put(iterator.next(), false);
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

	@Override
	public ArrayList<String> next(String node1, String node2, Dijkstra dijkstra) {
		// TODO Auto-generated method stub
		return null;
	}



}
