/**Group 5 Problem #1
 * Maximum spanning tree
 * 
 * Purpose:The purpose of the program is to find the maximum spanning tree in a weighted undirected connected graph.
 * 
 * A graph is initialized with the weight of the edges for each node. 
 * The start node is initialize to some arbitrary number ranging from 1 to the max amount of nodes. 
 * The maximal spanning tree is computed based upon the priority of the nodes. Lower priority gets listed first. 
 * The maximum amount of weight that the tree has is printed. 
 * The max spanning tree is then printed. 
 * 
 * Input: Initialized 2D array that represents the graph.
 * User input: none
 * Output:
 * a)	The sum of the weights on the edges in the maximum spanning tree. 
 * b)	The edges of the spanning tree represented as pairs of nodes. 
 * 
 * @author Kelby Kies 
 * @version #2
 * @Date 11/10/17
 */
public class GraphDriverMaxSpanTree {

	public static void main(String [] args)
	{
		int nodes = 6; 					//number of nodes
		int edges = 7;					//number of edges
		int start;						//some arbitrary start node
		
		int [][] spTable = new int[nodes][3];

			int [][] graph =  {{0, 8, 3, 6, 0, 0},				// undirected weighted graph
							  {8, 0, 0, 0, 0, 9},
							  {3, 0, 0, 5, 0, 0},
							  {6, 0, 5, 0, 2, 0}, 
							  {0, 0, 0, 2, 0, 1},
							  {0, 9, 0, 0, 1, 0}};
		                       
			System.out.println("The program computes the maximum spanning tree of a weighted graph.");
   
			start = 6;					
			start--;
		
			// compute span tree table		
			MaximumSpanningTree.maxSpanTree(start, nodes, edges, graph, spTable);
			MaximumSpanningTree.printWeight(nodes, spTable);
			MaximumSpanningTree.printSpanTree(nodes, spTable);
  }	
}
