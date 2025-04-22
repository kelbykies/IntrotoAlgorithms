
/**
 * class GraphDriver 
 *   initializes a graph
 *      reads the start node
 *      computes distance table
 *      shows paths
 *      repeats upon user request
 * 
 * @author (Lydia Sinapova) 
 * @version (2017)
 */
import java.util.*;
public class GraphDriver
{
    
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int nodes = 7; 
        int edges;
        int start;          // start vertex
        int target;         // vertex to see the path
        String ans1, ans2;  // ans1 - compute with new start vertex
                            // ans2 - see the path to another target vertex
        int [][] dTable = new int[nodes][2];
        
        int [][] graph = {{0, 3, 0, 2, 0, 0, 0},  // directed wighted graph
                           {0, 0, 0, 0, 8, 0, 0},
                           {6, 0, 0, 3, 0, 19, 0},
                           {0, 4, 0, 0, 0, 7, 0},
                           {0, 0, 0, 1, 0, 0, 2},
                           {0, 0, 0, 0, 0, 0, 4},
                           {0, 0, 0, 5, 0, 0, 0}};
   
    System.out.println("Shortest Path Algorithm in weighted directed graphs");
    System.out.println("Graph:");
    for (int i = 0; i < nodes; i++)
    {
        for (int j = 0; j < nodes; j++)
          System.out.print(graph[i][j] + " ");
        System.out.println();
    }
    System.out.println();
       	ans1 = "y";
	do
	{
		System.out.print("Enter start node: ");
		start = scan.nextInt();
		start = start-1;  // make the node to serve as index
// compute distance table		
		Graphs.minWeightPath(start, nodes, graph, dTable);
		Graphs.printDistanceTable(nodes, dTable);

// show paths		
		ans2 = "y";
		do
		{
		System.out.print("Enter a node to see the path : ");
		target = scan.nextInt();
		target = target - 1;   // make the node to serve as index
		Graphs.printMinPath(target,dTable);
		System.out.print("Another path? (y/n): ");
		ans2 = scan.next();
        }
         while(ans2.equals("y"));
         
     System.out.print("Another run? (y/n): ");
	 ans1 = scan.next();
    }
     while(ans1.equals("y"));                    

  } 
}
