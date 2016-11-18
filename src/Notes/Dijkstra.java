package Notes;

import java.util.*;

/**
 * The main Dijkstra class that performs Dijkstra's algorithm given a graph and
 * a start node.
 * @author William Yang
 *
 */
public class Dijkstra implements Shorty {

	//node from which to begin calculations
	public String startNode;

	//shortest path
	public HashMap<String, String> path;

	//used primarily to retrieve the indices of various nodes
	public ArrayList<String> nodeIndices;

	//previous node for a given node
	public ArrayList<String> pv;

	//whether a node has been visited or not
	private HashMap<String, Boolean> kMap;

	//cumulative distance from start node
	private ArrayList<Double> dv;

	//adjacency list representation of a graph
	private HashMap<String, HashMap<String, Integer>> nodeDistances;

	/**
	 * Creates a new <code>Dijkstra</code> by initializing the instance fields and
	 * evaluating the path.
	 * @param nodeDistances The adjacency list representation of a graph to be used to
	 * calculate the shortest paths from.
	 * @param start The start node.
	 */
	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start) {

		initialize(start, nodeDistances);
		evaluatePath(start, 0.0);

	}

	/**
	 * Initializes the <code>Dijkstra</code> class instance fields and sets the
	 * startNode's distance to 0.0 and sets it's kMap visited value to true.
	 * @param start The start node.
	 * @param nodeDistances Adjacency list representation of a graph to be used to calculate
	 * the shortest paths from.
	 */
	private void initialize(String start, HashMap<String, HashMap<String, Integer>> nodeDistances) {

		startNode = start;
		path = new HashMap<String, String>();
		this.nodeDistances = new HashMap<String, HashMap<String, Integer>>(nodeDistances);
		nodeIndices = new ArrayList<String>(nodeDistances.keySet());

		initializeDv(nodeDistances.size());
		initializekMap(nodeDistances);
		initializePv(nodeDistances.size());

		dv.set(nodeIndices.indexOf(start), 0.0);
		kMap.put(start, true);

	}

	/**
	 * Initializes dv with the default value of Double.POSITIVE_INFINITY.
	 * @param size Number of nodes in the graph.
	 */
	private void initializeDv(int size) {

		dv = new ArrayList<Double>();

		for(int i = 0; i < size; i++) {

			dv.add(Double.POSITIVE_INFINITY);

		}

	}

	/**
	 * Initializes kMap, setting all nodes to unvisited (<code>false</code>)
	 * @param nodeDistances Adjacency list representation of a graph to be used to calculate
	 * the shortest paths from.
	 */
	private void initializekMap(HashMap<String, HashMap<String, Integer>> nodeDistances) {

		kMap = new HashMap<String, Boolean>();

		Iterator<String> iterator = nodeDistances.keySet().iterator();

		while(iterator.hasNext()) {
			kMap.put(iterator.next(), false);
		}
	}

	/**
	 * Initializes pv, setting the previous nodes for all nodes to null.
	 * @param size Number of nodes in the graph.
	 */
	private void initializePv(int size) {

		pv = new ArrayList<String>();

		for(int i = 0; i < size; i++) {

			pv.add(null);

		}

	}

	/**
	 * Perform's Dijkstra's algorithm recursively, beginning with the startNode.
	 *
	 * @param startNode The node from which to compare neighboring node's distances.
	 * @param startDistance The cumulative distance from the initial startNode.
	 */
	public void evaluatePath(String startNode, double startDistance) {

		double nextMinDistance = Double.POSITIVE_INFINITY;
		String nextStartNode = "";

		//algorithm continues recursively until all the nodes have been visited
		if(kMap.containsValue(false)) {

			//nodes that current startNode is connected to
			ArrayList<String> distanceKeys = new ArrayList<String>(nodeDistances.get(startNode).keySet());

			//loops through all of the nodes that current startNode is connected to
			for(int i = 0; i < nodeDistances.get(startNode).size(); i++) {

				//updates distance and previous node only if the new distance is less than the current one
				if((nodeDistances.get(startNode).get(distanceKeys.get(i)) + startDistance) < dv.get(nodeIndices.indexOf(distanceKeys.get(i)))) {

					dv.set(nodeIndices.indexOf(distanceKeys.get(i)), nodeDistances.get(startNode).get(distanceKeys.get(i)) + startDistance);
					pv.set(nodeIndices.indexOf(distanceKeys.get(i)), startNode);

				}

			}

			/*
			 * Loop through all unvisited nodes to find nextStartNode.
			 * Unvisited node with the least distance will be the nextStartNode.
			 */
			for(int i = 0; i < dv.size(); i++) {

				if(!kMap.get(nodeIndices.get(i)) && dv.get(i) < nextMinDistance) {

					nextMinDistance = dv.get(i);
					nextStartNode = nodeIndices.get(i);

				}

			}

			path.put(startNode, nextStartNode);
			kMap.put(startNode, true);
			evaluatePath(nextStartNode, nextMinDistance);

		}

	}


}
