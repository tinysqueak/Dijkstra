Dijkstra's Algorithm Readme

Introduction:
---------------------------------
The purpose of this project is to implement Dijkstra's algorithm in Java.

Specifications:
---------------------------------
This program fulfills the specifications of the Dijkstra's algorithm project as a class called Dijkstra with a constructor taking a HashMap that maps a String to a HashMap that maps Strings to Integers (representing an adjacency list representation of a graph), and a String that represents a starting node was successfully created. In addition, the Dijkstra class also produces a public variable called path of type HashMap (from String to String), representing the sequence of vertices corresponding to single source shortest path as required by the specifications. Furthermore, the class also implements an interface with the required next method that returns the the shortest path between the argument String and the start node of the graph implicitly represented by the argument to the constructor of the Dijkstra object.

Current Errors:
---------------------------------
There are no significant errors currently, as the program is able to successfully perform Dijkstra's algorithm on some simple graphs, as well as the graph that was walked through in the presentation. There may be some slight issues with the path instance variable as the specifications were somewhat ambiguous for the exact purpose of path, as it seems the shortest path can already be found using the next method.

Code Overview:
---------------------------------
The general structure of the code involves the main Dijkstra class implementing the Shorty interface which specifies the next method as required by the specifications. The Dijkstra class contains instance fields corresponding to the startNode, the path HashMap as required by the specifications, an ArrayList of nodes in the graph, the HashMap adjacency list represenation of the graph itself, the ArrayList pv which holds the previous nodes for a given node, the HashMap kMap containing boolean values corresponding to whether or not a node has been visited, and the ArrayList dv which contains the cumulative distance from the startNode for every other node in the graph. The constructor for the Dijkstra object initializes these instance fields and then invokes the evaluatePath method to perform Dijkstra's algorithm. My implementation of Dijkstra's algorithm involves recursively calculating the next closest node for a given startNode. The method first loops through all the nodes that the current startNode is connected to and updates the distances in dv and previous nodes in pv only if the new distances is less than the current one. The method then loops through all the unvisited nodes to find the next nextStartNode, as the nextStartNode will be the unvisitedNode that has the least distance. The method then recursively invokes itself again, passing the nextStartNode and the nextMinDistance as the new startNodes and minDistances. The algorithm then repeats the same process for the nextStartNode to find the nextStartNode after that, etc. until all the nodes have been visited. More specific description of various parts of the code can be seen in the actual code documentation.

Major Challenges:
---------------------------------
Some major challenges I encountered included finding a way to link the nodeIndices of each node to their boolean values that determined whether they have been visited or not. I initially started out using k as an ArrayList, but ended up switching it to as HashMap, kMap, as I was then able to directly use the node names instead of their indices to change values. This proved to be more efficient as using the ArrayList involved finding the index by brute force.

Acknowledgements:
---------------------------------
I would like to thank Albert Ford providing a simple graph for me to test my code on, and Mr. Kuszmaul for his walkthrough of Dijkstra's algorithm and his half baked Dijkstra's algorithm code.
