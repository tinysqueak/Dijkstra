package Notes;

import java.util.*;

public class Dijkstra implements Shorty {

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
	//private ArrayList<Double> dv;
	
	private ArrayList<Integer> dv;
	
	private int startNodeIndex;
	
	private ArrayList<String> nodeIndices;
	private HashMap<String, HashMap<String, Integer>> nodeDistances;

	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start) {

		path = new HashMap<String, String>();
		this.nodeDistances = new HashMap<String, HashMap<String, Integer>>(nodeDistances);
		System.out.println(nodeDistances);
		initialize(start, nodeDistances);
		
		nodeIndices = new ArrayList<String>(nodeDistances.keySet());
		dv.set(nodeIndices.indexOf(startNode), 0);
		
		evaluatePath(start, 0);
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
		
		System.out.println(dv);
		

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
	
	public void test() {
		
		System.out.println(nodeIndices);
	
	}

	private void initializeDv(int size) {
		
		dv = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++) {
			
			dv.add(i, Integer.MAX_VALUE);
			
		}
		
	}

	/*private void initializeDv(int size) {

		dv = new ArrayList<Double>();

		for(int i = 0; i < size; i++) {

			dv.add(Double.POSITIVE_INFINITY);

		}

	}*/

	private void initializePv(int size) {

		pv = new ArrayList<String>();

		for(int i = 0; i < size; i++) {

			pv.add(null);

		}

	}
	
	public void evaluatePath(String startNode, int startDistance) {
		
		kMap.put(startNode, true);
		
		ArrayList<String> distanceKeys = new ArrayList<String>(nodeDistances.get(startNode).keySet());
		
		int minDistance = nodeDistances.get(startNode).get(distanceKeys.get(0)) + startDistance;
		String nextStartNode = distanceKeys.get(0);
		
		for(int i = 0; i < nodeDistances.get(startNode).size(); i++) {
			
			dv.set(nodeIndices.indexOf(distanceKeys.get(i)), nodeDistances.get(startNode).get(distanceKeys.get(i)) + startDistance);
			
			minDistance = (minDistance < nodeDistances.get(startNode).get(distanceKeys.get(i)) + startDistance)
					? minDistance : nodeDistances.get(startNode).get(distanceKeys.get(i)) + startDistance;
			nextStartNode = (minDistance < nodeDistances.get(startNode).get(distanceKeys.get(i)) + startDistance)
					? nextStartNode : distanceKeys.get(i);
			
		}
		
		for(int i = 0; i < nodeDistances.get(startNode).size(); i++) {
			
			pv.set(nodeIndices.indexOf(distanceKeys.get(i)), startNode);
			
		}
		
		path.put(startNode, nextStartNode);
		
		System.out.println(dv);
		System.out.println(pv);
		System.out.println(kMap);
		
		//evaluatePath(nextStartNode);
		
	}

	@Override
	public ArrayList<String> next(String node1, String node2, Dijkstra dijkstra) {
		// TODO Auto-generated method stub
		return null;
	}



}
