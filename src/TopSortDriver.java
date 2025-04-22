
/**
 * TopSortDriver 
 *   The class is used to test the topological sort 
 *   The graph is initialized in the main method
 *   
 * @author (Lydia Sinapova) 
 * @version (10/25/17)
 */
public class TopSortDriver
{
    public static final int NODES = 6;
    public static void main (String [] args)
    {
        //variable declarations
        
        int nodes = NODES;    
        int [][] graph =     {{0,2,0,3,0,0},
                              {0,0,1,0,10,0},
                              {0,0,0,0,0,11},
                              {0,2,0,0,9,0},
                              {0,0,0,0,0,4},
                              {0,0,0,0,0,0}};      
        int [] sorted = new int [NODES];   // to contain the sorted nodes
        int sNodes = 0;                    // to contain the number of sorted nodes
         
         //Method Call
         sNodes = TopSort.topSort(graph, sorted, nodes);
         //Check for cycles; if there are cycles, print appropriate message
         if (sNodes<nodes) 
           System.out.println("The Graph contains a cycle");
         
         // If the number of sorted nodes is greater than 0, 
         //     Print the topological sort
         if(sNodes > 0)
         {
          System.out.println("Sorted nodes:");
          for(int i = 0; i < sNodes;i++)
           System.out.print((sorted[i]+1) + " ");
          System.out.println();
         }
         System.out.println("\n\nEnd of program");  
        }
}
