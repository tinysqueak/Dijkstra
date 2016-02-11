package Notes;

import java.util.ArrayList;

public interface Shorty {
	
	public static ArrayList<String> next(String targetNode, Dijkstra dijkstra) {
		
		ArrayList<String> shortestPath = new ArrayList<String>();
		
		while(!shortestPath.contains(dijkstra.startNode)) {
			
			shortestPath.add(targetNode);
			targetNode = dijkstra.pv.get(dijkstra.nodeIndices.indexOf(targetNode));
			
		}
		
		for(int i = 0; i < shortestPath.size() / 2; i++) {
			
			String temp = shortestPath.get(i);
			
			shortestPath.set(i, shortestPath.get(shortestPath.size() - 1 - i));
			shortestPath.set(shortestPath.size() - 1 - i, temp);
			
		}
		
		return shortestPath;
		
	}

}
