
/**
 * Class Graphs
 * contains static methods to implement graph algorithms.
 * Methods to be implemented:
 *  public static void minWeightPath(int start, int nodes, 
 *                                   int [][] graph, int [][] dTable)
 *         computes dTable for directed weighted graphs
 *         dTable [][0] - records the distance
 *         dTable [][1] - records the parent
 *         
 *  public static void printMinPath(int target,int [][]dTable)
 *        prints the path to a specified node 'target'
 *        
 *  Implemented:                 
 *  public static int computeEdges(int nodes, int [][]graph)
 *         computes the number of edges given the adjacency matrix
 *         
 *  public static void printDistanceTable(int nodes, int [][] dTable) 
 *         prints the distance table for weighted graphs
 *         
 
 * @author (Kelby Kies) 
 * @version 1
 * @date November 1, 2018
 */
public class Graphs
{
    public static void minWeightPath(int start, int nodes,  
                                     int [][] graph, int [][] dTable)
    {
// compute the number of edges and declare a priority queue
    		int edges = computeEdges(nodes, graph);
    		PQueueCell pQueue = new PQueueCell(edges);
       
// initialize dTable
        for(int i = 0; i < nodes; i++)
	     {
	         dTable[i][0] = -1;
	         dTable[i][1] = -1;
	     }
	    dTable[start][0] = 0;  // distance to start node is 0
	    
// insert the start node with priority 0 in the queue:      
//       declare a variable of type Cell with key = 0 and item = start node
//       insert the variable in the priority queue

	    Cell temp = new Cell(0, start);	
	    pQueue.insert(temp);
	    
/* while queue is not empty    
     
   DeleteMin  a vertex vCell from the queue  
   get the item v from vCell (this is the node index v)
   
   For all nodes w adjacent to v: 
     compute new_distance = (distance to v) + (distance(v,w)) 
                
     if distance to w not computed or new distance is better
        store new_distance and parent v of w in the distance table
        store w in the queue with priority = new_distance
*/

	    while(!pQueue.isEmpty())
	    {
	    		Cell vCell = pQueue.deleteMin();
	    		int v = vCell.getItem();
	    		
	    		for(int w = 0; w < nodes; w++)
	    		{
	    			if(graph[v][w] != 0)
	    			{
	    				int newDistance = dTable[v][0] + graph[v][w];
	    				if(dTable[w][0] == -1 || dTable[w][0] > newDistance)
	    				{
	    					dTable[w][0] = newDistance;
	    					temp = new Cell(newDistance, w);
	    					pQueue.insert(temp);
	    					dTable[w][1] = v;
	    				}
	    			}
	    			
	    		}
	    }
	    
	    
}   
/*----------------------- print path to node --------------------------*/     
  public static void printMinPath(int target, int [][]dTable)
  {
      //   if no path to target node, i.e. distance not computed, print message
	  //   else
      //   print "path to <target> with distance <distance>:
      //   call recursivePathPrint(target, dTable) 
	  
	  if(dTable[target][0] == -1)
	  {
		  System.out.println("No Path between the start node and node " + (target + 1));
	  }
	  else
	  {
		  System.out.print("Path to " + (target + 1) + " with distance " + dTable[target][0] + ": ");
		  recursivePathPrint(target, dTable);
	  }
	  System.out.println();
   }
  
  public static void recursivePathPrint(int target, int [][] dTable)
  {  // Idea: the path to target is equal to the path to its parent + target
      /* if target = start
       *    print target
       *    return
       * else
       *    call recursivePathPrint with the parent of target
       *    print target
       */
	  if(dTable[target][0] == 0)
	  {
		  System.out.print((target + 1) + " ");
	  }
	  else
	  {	 
		  recursivePathPrint(dTable[target][1], dTable);
		  System.out.print((target + 1) + " ");
	  }
  }
/*------------------ compute edges -------------------------------*/
public static int computeEdges(int nodes, int [][]graph)
{
   int edges = 0;
   for( int i = 0; i < nodes; i++)
    for( int j = 0; j < nodes; j++)
      if (graph[i][j] != 0) edges++; 
   return edges;
}
/*-------------------- print distance table ---------------------------*/
 public static void printDistanceTable(int nodes, int [][] dTable)
 {
   System.out.println("Distance table:");
   System.out.println("Node\tDistance\t\tParent");
     for (int i = 0; i < nodes; i++)
      System.out.println((i+1) +"\t" + dTable[i][0] + "\t\t" + (dTable[i][1]+1));
     System.out.println();  
 }
}
