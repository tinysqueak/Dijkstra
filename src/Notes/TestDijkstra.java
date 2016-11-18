package Notes;

import java.util.*;

/**
 * Some test graphs!
 * @author William Yang
 *
 */
public class TestDijkstra {

	public static void main(String[] args) {

		System.out.println("TESTING TEST GRAPH");

		HashMap<String, HashMap<String, Integer>> testGraph = new HashMap<String, HashMap<String, Integer>>();

		HashMap<String, Integer> gDistances = new HashMap<String, Integer>();
		gDistances.put("H", 3);
		gDistances.put("D", 2);

		HashMap<String, Integer> hDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> dDistances = new HashMap<String, Integer>();

		testGraph.put("G", gDistances);
		testGraph.put("H", hDistances);
		testGraph.put("D", dDistances);

		Dijkstra test = new Dijkstra(testGraph, "G");
		System.out.println(Shorty.next("H", test));

		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> Amap = new HashMap<String, Integer>();
		HashMap<String, Integer> Bmap = new HashMap<String, Integer>();
		HashMap<String, Integer> Cmap = new HashMap<String, Integer>();
		Amap.put("B", 3);
		Amap.put("C", 1);
		Cmap.put("A", 4);
		Cmap.put("B", 1);
		graph.put("A", Amap);
		graph.put("B", Bmap);
		graph.put("C", Cmap);

		Dijkstra test2 = new Dijkstra(graph, "A");

		System.out.println("Ford test graph: " + Shorty.next("B", test2));
		// [A, C, B]

		HashMap<String, HashMap<String, Integer>> presentationGraph = new HashMap<String, HashMap<String, Integer>>();

		HashMap<String, Integer> aNodes = new HashMap<String, Integer>();
		HashMap<String, Integer> bNodes = new HashMap<String, Integer>();
		HashMap<String, Integer> cNodes = new HashMap<String, Integer>();
		HashMap<String, Integer> dNodes = new HashMap<String, Integer>();
		HashMap<String, Integer> eNodes = new HashMap<String, Integer>();
		HashMap<String, Integer> fNodes = new HashMap<String, Integer>();
		HashMap<String, Integer> gNodes = new HashMap<String, Integer>();
		HashMap<String, Integer> hNodes = new HashMap<String, Integer>();

		aNodes.put("F", 10);
		aNodes.put("B", 8);

		bNodes.put("C", 4);
		bNodes.put("E", 10);

		cNodes.put("D", 3);

		dNodes.put("E", 25);
		dNodes.put("F", 18);

		eNodes.put("G", 7);
		eNodes.put("D", 9);

		fNodes.put("E", 2);
		fNodes.put("C", 3);
		fNodes.put("A", 5);
		fNodes.put("B", 7);

		gNodes.put("H", 3);
		gNodes.put("D", 2);

		hNodes.put("A", 4);
		hNodes.put("B", 9);

		presentationGraph.put("A", aNodes);
		presentationGraph.put("B", bNodes);
		presentationGraph.put("C", cNodes);
		presentationGraph.put("D", dNodes);
		presentationGraph.put("E", eNodes);
		presentationGraph.put("F", fNodes);
		presentationGraph.put("G", gNodes);
		presentationGraph.put("H", hNodes);

		Dijkstra presentationDijkstra = new Dijkstra(presentationGraph, "G");
		System.out.println(Shorty.next("E", presentationDijkstra));

	}

}
