package Notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


// This is half baked code but it gives you some working code that works with Hashmaps
// like are required in the Dijkstra's algorithm assignment...
/**
 * 
 * @author William Yang
 *
 */
public class Graph3 {

	private HashMap<String, ArrayList<String>> adjacencies;
	private HashMap<String, HashMap<String, Integer>> nodeDistances;

	public static void main(String[] args) {

		// Create a graph like on the board:
		// A to b and c
		// B to nothing
		// c to a.
		Graph3 threeNodes = new Graph3();
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

		Dijkstra myd = new Dijkstra(threeNodes.nodeDistances, "A");
		HashMap<String,String> paths = myd.path;
		// shortest path from "A" to "B" is:

		ArrayList<String> myPath = new ArrayList<String>();
		String nodeInPath = "B";
		myPath.add(nodeInPath);
		/*while(!nodeInPath.equals("A")){
		   nodeInPath = paths.get(nodeInPath);
		   myPath.add(nodeInPath);
		}*/

		//myd.test();
		System.out.println(Shorty.next("C", myd));
		
		System.out.println();
		
		System.out.println("TESTING TEST GRAPH");
		
		
		HashMap<String, HashMap<String, Integer>> testGraph = new HashMap<String, HashMap<String, Integer>>();
		
		HashMap<String, Integer> gDistances = new HashMap<String, Integer>();
		gDistances.put("H", 3);
		gDistances.put("D", 2);
		
		HashMap<String, Integer> hDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> dDistances = new HashMap<String, Integer>();

		//may need to fix case where there are no doubly linked nodes
		testGraph.put("G", gDistances);
		testGraph.put("H", hDistances);
		testGraph.put("D", dDistances);
		
		Dijkstra test = new Dijkstra(testGraph, "G");
		System.out.println("Prior Node to H: " + test.priorNode("H"));
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
        
        
	}

	/*private void play(){


		String[] nodes = {"G","H","D"};

		HashMap> distanceGraph;

		distanceGraph = new HashMap>();

		// Node initialization to be encapsulated.
		String startNode = "G";
		HashMap Gconnections;
		Gconnections = new HashMap();

		String nodeH = "H";
		HashMap Hconnections;
		Hconnections = new HashMap();

		String nodeD = "D";
		HashMap Dconnections;
		Dconnections = new HashMap();

		Gconnections.put(nodeH, 3);
		Gconnections.put(nodeD, 2);

		distanceGraph.put(startNode, Gconnections);
		distanceGraph.put(nodeH, Hconnections);
		distanceGraph.put(nodeD, Dconnections);
		// required!
		Dijkstra myD = new Dijkstra(distanceGraph, startNode);

		String nodepriortoHinpathfromGtoH = myD.prev.get(myD.nodes.indexOf("H"));

		// required!
		ArrayList path = Shorty.next("H", myD);
		// path should be ["G","H"] 



		ArrayList myPath = new ArrayList();
		ArrayList myPathfromnp = new ArrayList();
		String nodeInPath = "B";
		myPath.add(nodeInPath);
	}*/

}
