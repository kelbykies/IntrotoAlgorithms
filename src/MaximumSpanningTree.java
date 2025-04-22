import java.util.Arrays;
/**
 * Class MaximumSpanningTree
 *
 * Methods 
 *    
 *  public static void maxSpanTree(int start, int nodes,int edges, int [][] graph, int [][] spTable) 
 *         computes spTable for undirected weighted graphs
 *         
 *  public static void printSpanTreeTable (int nodes, int [][] spTable) 
 *         prints the span tree table for weighted graphs
 *         
 * public static void printSpanTree(int nodes,int [][]spTable)
 *        prints the edges of the spanning tree with their weights
 *        
 * public static void printWeight(int nodes,int [][]spTable)
 *        prints the total weight of the spanning tree 
 *        
 * @author Kelby Kies 
 * @version 1
 */
public class MaximumSpanningTree {

	public static void maxSpanTree(int start, int nodes, int edges, int [][] graph, int [][] spTable)
	{
	   //  initialize spTable   
	   //    with 0 in the fixed column spTable[k][0] 
	   //    with -1 in the parent column spTable[k][1] 
	   //    with 0 in the weight column  spTable[k][2] 
	    	for(int k = 0; k < nodes; k++)
	    	{
	    		spTable[k][0] = 0;
	    		spTable[k][1] = -1;
	    		spTable[k][2] = 0;
	    	}
	   
	   //declare a priority queue of type Cell and size = number of edges
	    	PQueueCell pQueue = new PQueueCell(edges);
	    	
	   // insert the start node with priority 0 in the queue    
	    	Cell temp = new Cell(0, start);	
		pQueue.insert(temp);
	   
	   /*while queue is not empty   
	       
	         DeleteMin  a cellNode from the priority queue 
	         get node v from cellNode
	         fix the node, decrement counter
	         For all nodes w adjacent to  v and not fixed: 
	             if w is not included in the tree or
	                   the current edge weight (graph[v][w]) is less than the recorded edge spTable[w][2]
	                   
	                   a. record edge weight in spTable [w][2]
	                   b. record the parent v spTable[w][1]
	                   c. insert w in the priority queue with priority the edge weight     
	    */
		
		 while(!pQueue.isEmpty())
		    {
		    		Cell vCell = pQueue.deleteMin();
		    		int v = vCell.getItem();
		    		spTable[v][0] = 1;
		    		
		    		for(int w = 0; w < nodes; w++)
		    		{
		    			if(graph[v][w] != 0 )
		    			{       		
		    				if(spTable[w][0] == 0 && (spTable[w][1] == -1 || graph[v][w] > spTable[w][2]))
		    				{
		    					spTable[w][2] = graph[v][w];
		    					spTable[w][1] = v;
		    					temp = new Cell(graph[v][w], w);
		    					pQueue.insert(temp);
		    				}
		    			}
		    		}
		    }
	} 

	 /*-------------------- print span tree Table ---------------------------*/
	 public static void printSpanTreeTable (int nodes, int [][] spTable)
	 {
		 System.out.println("Max Span Tree table:");
	     System.out.println("fixed" + "\t" + "parent" +"\t" + "weight");
	     for (int i = 0; i < nodes; i++)
	              System.out.println( spTable[i][0] + "\t" + (spTable[i][1] + 1) +"\t" + spTable[i][2]) ;
	     System.out.println();
	 }
	/*-------------------- print span tree ---------------------------*/
	 public static void printSpanTree(int nodes, int [][] spTable)
	 {
		System.out.println("Max spanning tree: ");
	    for(int i = 0; i < nodes; i++)
	    {
	    		if(spTable[i][2] != 0)
	    		{
	    			System.out.println((i+1) + " " + (spTable[i][1] + 1));
	    		}
	    }
	    System.out.println();
	     
	 }
	/*----------------------- print total weight --------------------------*/     
	  public static void printWeight(int nodes, int [][]spTable)
	  {
	    int total = 0;					//total weight on the edges
	    for(int j = 0; j < nodes; j++)
	    {
	    		total += spTable[j][2];
	    }
	    
	    System.out.println("Total sum of weights on the max spanning tree: " + total); 
	  }

	}

