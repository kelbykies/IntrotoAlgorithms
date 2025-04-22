
/**
 * class GraphDriver 
 *      initializes a graph
 *      reads the start node
 *      computes minimal spanning tree
 *      shows span table, tree edges and total weight
 *      repeats upon user request
 * 
 * @author (Lydia Sinapova) 
 * @version 11/08/17
 */
import java.util.*;
public class GraphDriverMinSpanTree
{
	
	public static void main(String [] args)
	{
	    Scanner scan = new Scanner(System.in);
		int nodes = 7; 
		int edges = 10;
		int start;
		
		int [][] spTable = new int[nodes][3];

			int [][] graph =  {{0, 1, 0, 4, 0, 0, 0},  // undirected weighted graph
		                       {1, 0, 0, 5, 4, 0, 0},
		                       {0, 0, 0, 2, 8, 6, 0},
		                       {4, 5, 2, 0, 0, 3, 2},
		                       {0, 4, 8, 0, 0, 0, 0},
		                       {0, 0, 6, 3, 0, 0, 2},
		                       {0, 0, 0, 2, 0, 2, 0}};
		                       

    System.out.println("The program computes the minimal spanning tree of a weighted graph");
   
    String answer = "y";
	do
	{
		System.out.print("Please enter the start node (1 to " + nodes + "): ");
		start = scan.nextInt();
		start--;
// compute span tree table		
		GraphsMinSpanTree.minSpanTree(start, nodes, edges, graph, spTable);
		GraphsMinSpanTree.printSpanTreeTable (nodes, spTable);
		GraphsMinSpanTree.printSpanTree(nodes, spTable);
		GraphsMinSpanTree.printWeight(nodes, spTable);
		System.out.print("Another run? (y/n): ");
	    answer = scan.next();
     }
     while(answer.equals("y"));
  }	
}
