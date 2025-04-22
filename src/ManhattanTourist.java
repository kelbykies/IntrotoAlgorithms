
/**
 * class ManhattanTourist 
 * 
 * Implements the Manhattan Tourist algorithm 
 * Prints the created dynamic table and restores the best path
 * 
 * @author  
 * @version 
 */
import java.util.*;
public class ManhattanTourist
{
public static void main (String [] args)
    {
        int [][] eastEdges = {{3,2,4,0},
                              {3,2,4,2},
                              {0,7,3,4},
                              {3,3,0,2},
                              {1,3,2,2}};
        int [][] southEdges = {{1,0,2,4,3},
                               {4,6,5,2,1},
                               {4,4,5,2,1},
                               {5,6,8,5,3}};
 
 /*
   The two tables above encode the grid below.
   points in the grid: "o".
   The numbers represent the distances between two
   horizontal or vertical neighbors
   
   o  - 3 - o - 2 - o - 4 - o - 0 - o
   |        |       |       |       |
   1        0       2       4       3
   |        |       |       |       |   
   o  - 3 - o - 2 - o - 4 - o - 2 - o   
   |        |       |       |       |
   4        6       5       2       1
   |        |       |       |       |     
   o  - 0 - o - 7 - o - 3 - o - 4 - o  
   |        |       |       |       |
   4        4       5       2       1
   |        |       |       |       |  
   o  - 3 - o - 3 - o - 0 - o - 2 - o   
   |        |       |       |       |
   5        6       8       5       3
   |        |       |       |       |   
   o  - 1 - o - 3 - o - 2 - o - 2 - o   
   
  */
 
        int east = 4;   // (4,4) are the coordinates of the bottom rightmost point
        int south = 4;
        
        int [][] paths = new int [south+1][east+1]; 
                //  paths[i][j] holds the largest score of a path to point [i][j]
        
        paths[0][0] = 0;
        int i,j;
  
 // 1. initialize the top row of the 'paths' array
 
        for(int k = 1; k <= east; k++)
        {
        		paths[0][k] = paths[0][k-1] + eastEdges[0][k-1];
        }
 
 // 2. initialize the leftmost column of the 'paths' array 
 
        for(int k = 1; k <= south; k++)
        {
        		paths[k][0] = paths[k-1][0] + southEdges[k-1][0];
        }
 
 // 3. Fill the dynamic table row by row       
 //    paths[j][k] = max of (paths[j-1][k] +  southEdges [j-1][k]) 
 //                      and (paths[j][k-1] + eastEdges[j][k-1] ),
 //                      j = 1, 2, �. south,  k = 1, 2, � east
        for(int h = 1; h <= south; h++)
        {
        		for(int k = 1; k <= east; k++)
        		{
        			if((paths[h-1][k] + southEdges[h-1][k]) > (paths [h][k-1] + eastEdges[h][k-1]))
        			{
	        			paths[h][k] = (paths[h-1][k] + southEdges [h-1][k]);
        			}
        			else
        			{
        				paths[h][k] = (paths[h][k-1] + eastEdges[h][k-1]);
        			}
        		}
        }
 
 // 4. Print dynamic table
     System.out.println ("Dynamic table computed:");
      for(i = 0; i <= south; i++)
      {
        for(j = 0; j <= east; j++)      
          System.out.print(paths[i][j] + ",\t");
        System.out.println();
      }
      System.out.println();
      
 // 5. Restore the path and record it in an array    
 
      int[][] bestPath = new int[(south + east + 1)][2];
      int southIndex = south;
      int eastIndex = east;
      int bestpathIndex = 1;
      
      bestPath[0][0] = south;
      bestPath[0][1] = east;
      
      while(southIndex > 0 && eastIndex > 0) 
      {
    	  	if((paths[southIndex-1][eastIndex] + southEdges[southIndex-1][eastIndex]) > (paths [southIndex][eastIndex-1] + eastEdges[southIndex][eastIndex-1]) )
    	  	{
    	  		bestPath[bestpathIndex][0] = southIndex-1;
        	  	bestPath[bestpathIndex][1] = eastIndex;
    	  		southIndex--;
    	  	}
    	  	
    	  	else
    	  	{
    	  		bestPath[bestpathIndex][0] = southIndex;
        	  	bestPath[bestpathIndex][1] = eastIndex - 1;
    	  		eastIndex--;
    	  	}
    	  
    	  	bestpathIndex++;
      }
      
 // 6. Print the path
 
      System.out.println("Best Path: ");
      System.out.println();
      System.out.println("From (" + (bestPath[bestpathIndex][0]) + "," + bestPath[bestpathIndex][1] + ")");
      for(int x = bestpathIndex - 1; x >= 0; x--)
      {
    	  	if(bestPath[x][0] > bestPath[x + 1][0])
    	  	{
    	  		System.out.println("Go South to (" + bestPath[x][0] + "," + bestPath[x][1] + ")");
    	  	}
    	  	else
    	  	{
    	  		System.out.println("Go East  to (" + bestPath[x][0] + "," + bestPath[x][1] + ")");
    	  	}
      } 
      System.out.println();
 
 // 7. Print the value of attractions along the path
 
      System.out.println("Value of the path: " + paths[south][east]);
}  

   
}
