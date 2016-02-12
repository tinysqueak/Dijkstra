package Notes;

import java.util.ArrayList;

/**
 * Interface with the <code>next</code> method as required in the specifications.
 * @author William Yang
 *
 */
public interface Shorty {
	
	/**
	 * Determines the shortest path from the start node of the <code>Dijkstra</code> object to 
	 * the specified target node.
	 * @param targetNode The target node to find the path to.
	 * @param dijkstra The <code>Dijkstra</code> object to be used as a container for the graph.
	 * @return An <code>ArrayList</code> representation of the shortest path to the target node.
	 */
	public static ArrayList<String> next(String targetNode, Dijkstra dijkstra) {
		
		ArrayList<String> shortestPath = new ArrayList<String>();
		
		//loops through and adds the previous nodes from the target node until reaching the start node
		while(!shortestPath.contains(dijkstra.startNode)) {
			
			shortestPath.add(targetNode);
			targetNode = dijkstra.pv.get(dijkstra.nodeIndices.indexOf(targetNode));
			
		}
		
		/*
		 * swaps first half with last half so shortestPath has nodes in order from start node
		 * to target node
		 */
		for(int i = 0; i < shortestPath.size() / 2; i++) {
			
			String temp = shortestPath.get(i);
			
			shortestPath.set(i, shortestPath.get(shortestPath.size() - 1 - i));
			shortestPath.set(shortestPath.size() - 1 - i, temp);
			
		}
		
		return shortestPath;
		
	}

}
