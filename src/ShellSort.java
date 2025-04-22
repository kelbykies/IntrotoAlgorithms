
/**
 * class ShellSort : implements four Shell sort algorithms :
 * 
 * orginal Shell sort, Hibbard increments, Knuth increments, and Sedgewick increments.
 * each method returns the number of swap operations.
 * 
 * Contains insertion sort method for comparison.
 * 
 * Implementation details about Hibbard, Knuth and Sedgewick sorts:
 * Each method first computes the increments and then calls a method 'basicSort'
 * that performs the sorting with the given increments
 *
 * @author (Lydia Sinapova) 
 * @version (10/13/11)
 */
import java.util.*;

public class ShellSort
{
    
    public static int insertionSort(int [] array)
    {
      int size = array.length;
      int j, p;
      int tmp;
      int swaps = 0;
      for ( p = 1; p < size; p++)
       {
        
        tmp = array[p];
            
        for (j = p; j > 0 && tmp < array[j-1]; j--)
        {
            array[j] = array[j-1];
            swaps++;
        }
    
        array[j] = tmp; 
        swaps++;
      }
      return swaps;
   }
/*--------------------shell sort for arrays ----------------------------*/
 public static int shellSort(int[] array)
  {
    int size = array.length;
    int j, p, gap;
    int tmp;
    int swaps = 0;    
       for (gap = size/2; gap > 0; gap = gap/2)
       {
           
            for ( p = gap; p < size; p++)
            {
                tmp = array[p];
                
                for (j = p; j >=gap && tmp < array[j-gap]; j= j-gap)
                {
                    array[j] = array[j-gap];
                    swaps++;
                }
                    
                array[j] = tmp; swaps++;
            }
       }
     return swaps;
    }
/*----------------------- sedgeSort -------------------------------------*/ 
// Sedgewick: 1, 5, 19, 41, 109, ....,
// Interleave elements of two sequences:  1, 19, 109, ... 1 + 9*(4^k) - 9*(2^k), k = 0, 1, 2, ... 
// and 5, 41,209, ...2^(k+2)*(2^(k+2) - 3) +1, k = 0, 1, 2, 

 public static int sedgeSort(int [] array)
{
  int size = array.length;
  int i,j, p, gap;
  int swaps=0;
  int tmp;
  int []increments; 
  int num_incr;
  
  int k = 0;
  
  // compute the number of increments
  do
  {
      tmp = (int)Math.pow(2,(k+2))* ((int)Math.pow(2,(k+2)) - 3) +1; 
      k++;
  }
  while(tmp <= (size/2));
  
  num_incr = (k-1);  // to account for elements from the two sequences
  
 // fill the array with increments 
  increments = new int [2*num_incr]; // to accomodate elements from both sequences
  for(k = 0; k < num_incr; k++)
  {
      increments[2*k]=1+9*(int)Math.pow(4,k)-9*(int)Math.pow(2,k);
      increments[2*k+1] = (int)Math.pow(2,(k+2))* ((int)Math.pow(2,(k+2)) - 3) +1; 
  }
  System.out.println("number of Sedgewick increments: " + 2*num_incr);
  for (k = 0; k < 2*num_incr; k++)
    System.out.print(increments[k] + " ");
  System.out.println();
  
    swaps = basicSort(array, increments);
  
    return swaps;
}
/*------------------------Hibbard----------------------------------------*/
// Hibbard: 1, 3, 7, ..., 2^k - 1 , k > 0; 

public static int hibbardSort(int array[])
 {
    int size = array.length;
    int j, p, gap,i;
    int tmp;
    int swaps = 0;
    int num_incr;    // number of the increments
    int []increments;                                   
  
  
   // compute the number of increments
  int k = 0;
  do
  {
      tmp= (int)Math.pow(2,(k+1))-1;
      k++;
  }
  while(tmp <= (size/2));
  
  num_incr = k-1;

 // fill the array with increments 
  increments = new int [num_incr];
  for(k = 0; k < num_incr; k++)
      increments[k]=(int)Math.pow(2,(k+1))-1;
  
  System.out.println("number of Hibbard's increments: " + num_incr);
  for (k = 0; k < num_incr; k++)
    System.out.print(increments[k] + " ");
  System.out.println();
  
    swaps = basicSort(array, increments);
 
    
    return swaps;

}
//-----------------------------Knuth Sort---------------------------------------------//
// Knuth:   1, 4, 13, ..., (3^k - 1) / 2 , k > 0; 

public static int knuthSort(int array[])
{
    int size = array.length;
    int j, p, gap, i;
    int tmp;
    int swaps = 0;
    int num_incr;                        // number of the increments
 int []increments;                                   
  
  
// compute the number of increments
  int k = 0;
  do
  {
      tmp= ((int)Math.pow(3,(k+1))-1)/2;
      k++;
  }
  while(tmp <= (size/2));
  
  num_incr = k-1;
  
// fill the array with increments   
  increments = new int [num_incr];
  for(k = 0; k < num_incr; k++)
      increments[k]=((int)Math.pow(3,(k+1))-1)/2;
  
  System.out.println("number of Knuth's increments: " + num_incr);
  for (k = 0; k < num_incr; k++)
    System.out.print(increments[k] + " ");
  System.out.println();
  
  swaps = basicSort(array, increments);
  return swaps;
}
/*----------------------------basic increment sort ---------------------*/
public static int basicSort(int array[], int increments[])
{
    int size = array.length;
    int num_incr = increments.length;                        // number of the increments
    int j, p, gap, i;
    int tmp;
    int swaps = 0;
   
    for (i = num_incr -1 ; i >=0 ; i--)
    {
       gap = increments[i];
            for ( p = gap; p < size; p++)
            {
                tmp = array[p];
                
                for (j = p; j >=gap && tmp < array[j-gap]; j= j-gap)
                {
                    array[j] = array[j-gap];
                    swaps++;
                }
                    
                array[j] = tmp; swaps++;
            }
    }
    return swaps;
}
}    // end class
