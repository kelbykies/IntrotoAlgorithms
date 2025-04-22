
/**
 * class Shell_sortDriver : implements a driver for the Shell sort methods
 * 
 * Action:
 * Generates an array of random numbers and then calls the sorting methods.
 * 
 * Reports results
 * 
 * @author (Lydia Sinapova) 
 * @version (10/10/17)
 */
import java.util.*;
public class ShellSortTest
{
    public static void main(String args[])
    {
        
        Scanner scan = new Scanner(System.in);
               
        int size;       // user-specified size of teh array to be sorted
        int upper;      // user-specified upper limit of generated numbers
        int option;     // type of file to be sorted: random, pre-sorted, reversed sorted
        int swaps;      // number of swaps returned by the sorting methods
              
        String answer;  // run again y/n
        int i, k;
        
        int [] array;   // array to be sorted
        int [] arrayToSort; // copy of array to be sorted
        
    System.out.println("This program sorts an array of integers");
    System.out.println("with Insertion sort, ShellSort, SedgeSort, Hibbard sort and Knuth sort");
    
    
    do
    {  System.out.println();
       System.out.println(" *************** New Run *******************");
       
         System.out.print("Enter the number of elements to be sorted: ");
         size = scan.nextInt();
         array = new int[size];
         System.out.print("Enter the upper limit of random values: ");
         upper = scan.nextInt();
         create_array(array, size,  upper);
               
         arrayToSort = new int[size];

//Display original array
        System.out.println("If the size of the array is > 50, only the first 50 elements will be printed");
        System.out.println("Original Elements:");
        for ( i = 0; i < size && i < 50; i++)
            System.out.print(array[i] + " ");
        System.out.println();
     
// call  insertion sort
        if(size > 75000)
         System.out.println("\nArray too large. Insertion sort skipped.");
        else
        {
        copyArray(array,arrayToSort);
        swaps = ShellSort.insertionSort(arrayToSort);
        System.out.println();
        System.out.println( "Insertion sort for " + size + " elements sorted with " + swaps + " swaps");
       
          for ( i = 0; i < size && i < 50; i++)
            System.out.print(arrayToSort[i] + " ");
          System.out.println();      
        }
        System.out.println();
        
 // call Shell sort       
        copyArray(array,arrayToSort);
        swaps = ShellSort.shellSort(arrayToSort);       
        System.out.println( "SHELL SORT for " + size + " elements sorted with " + swaps + " swaps");
         
          for ( i = 0; i < size && i < 50; i++)
            System.out.print(arrayToSort[i] + " ");
          System.out.println();         
       
        System.out.println();
 
       
 // call Hibbard sort
        copyArray(array,arrayToSort);
        swaps = ShellSort.hibbardSort(arrayToSort);       
        System.out.println( "Hibbard sort for " + size + " elements sorted with " + swaps + " swaps");
         
         for ( i = 0; i < size && i < 50; i++)
            System.out.print(arrayToSort[i] + " ");
         System.out.println();         
         
        System.out.println();
        
 // call Knuth sort
        copyArray(array,arrayToSort);
        swaps = ShellSort.knuthSort(arrayToSort);       
        System.out.println( "Knuth sort for " + size + " elements sorted with " + swaps + " swaps");
       
         for ( i = 0; i < size && i < 50; i++)
            System.out.print(arrayToSort[i] + " ");
         System.out.println();         
        
 // call Sedgewick sort
        copyArray(array,arrayToSort);
        swaps = ShellSort.sedgeSort(arrayToSort);       
        System.out.println( "\nSedgewick sort for " + size + " elements sorted with " + swaps + " swaps");
        
          for ( i = 0; i < size && i < 50; i++)
            System.out.print(arrayToSort[i] + " ");
          System.out.println();         
         
       System.out.println();    
       System.out.print("More tests? (y/n) ");
       answer = scan.next();
     }
      while(answer.equals("y"));
      System.out.println("End of program");
     
 }  
 /* ------------------ create an array ------------------------------*/
 public static void create_array(int[]array, int size, int upper)
 {
    int i;
    Random generator = new Random();
    for ( i = 0; i < size; i++)
    {
        array[i]=generator.nextInt(upper);
    }
 }
 
/*----------------------- copy array -------------------------------*/ 
 public static void copyArray(int[] a1, int []a2)
 {
     int size = a1.length;
     for(int i = 0; i < size;i++)
       a2[i] = a1[i];
 }
} // end class
