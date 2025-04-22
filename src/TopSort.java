/**
 * Class TopSort- Implements the topological sort of directed acyclic graph
 * 
 * The graph is initialized in the main method
 * the sort is implemented in the method topSort
 *      public static int topSort(int[][] edges, int [] sorted, int nodes)

 *      Parameters:
 *      int[][] graph � the graph represented by an adjacency table
 *      int [] sorted � an array that will contain the sorted nodes
 *                      The array is instantiated in the main method
 *      int nodes � the number of the nodes in the graph

 *      return value � the number of the sorted nodes


 *      the method uses a queue, implemented as class Queue
 *  Constructor: 
 *      public Queue(int size)
 *  Methods:
 *      public void enQueue (int element)
 *      public int deQueue ()
 *      public boolean isEmpty()
 * author (Kelby Kies)
 * 10/30/2018
 * version (1)
 */
public class TopSort 
{   
    
 /*----------------------------------------------------------------------------*/
    public static int topSort(int[][] edges, int[] sorted, int nodes)
    {
        int counter = 0; // counts the sorted nodes, 
                         //serves as an index in the sorted array
        
        // Declare a queue and the array 'indegree'
        	int[] indegree = new int[nodes];
        	Queue queue = new Queue(nodes);
             
        // Compute the indegree array, and store nodes with indegree 0 in the queue
        for(int column = 0; column < nodes; column++ )
        {
        		for(int row = 0; row < nodes; row++)
        		{
        			if(edges[row][column] != 0)
        			{
        				indegree[column]++;
        			}
        		}
        }
        
        
        for(int i = 0; i < nodes; i++)
        {
	        if(indegree[i] == 0)
	        {
			 	queue.enQueue(i);
	        }
        }
       
        
        /*Main algorithm:
        While the queue is not empty do
                dequeue a node 'current' and store in the sorted array. 
                increment counter
                For all edges (current,v)  
                    decrement the indegree of v, 
                    if the new indegree is 0, put v in the queue.
        */
        
        while(!queue.isEmpty())
        {
        		int current = queue.deQueue();
        		
        		sorted[counter] = current;
        		counter++;
        		
        		for(int v = 0; v < nodes; v++)
        		{
        			if(edges[current][v] != 0)
        			{
        				indegree[v]--;
        				if(indegree[v] == 0)
        				{
        					queue.enQueue(v);
        				}
        			}
        		}
        }
        
       return counter;  
    }
}
