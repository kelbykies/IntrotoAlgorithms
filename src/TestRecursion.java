
/**
 * class TestRecursion
 *  Illustrates recursive print of an array
 *      with left and right recursion
 * to be implemented:
 *         method public static int power(int a, int n)
 *         to recursively compute a^n, where 'a' and 'n' are user-entered values
 *         
 * @author (LS and class) 
 * @version (09/10/18)
 */
import java.util.Scanner;
public class TestRecursion
{
    public static void main (String [] args)
    {
  // Part 1: print array recursively
    int [] array = {1,2,3,4,5};
    System.out.println("Top Left Recursion Call with N = 5");
    printArrayLeftRecursion(array,5);
    
    System.out.println("\n\nTop Right Recursion Call with N = 5");
    printArrayRightRecursion(array,5);
    
   // Part 2: Compute a^n
    System.out.println("Computing a^n recursively");
    String runAgain = "y";
    Scanner scan = new Scanner(System.in);
    int a;          // positive number to be raised to a specified power
    int n;          // the power of 'a'
    int aToPowerN;  // the number 'a' raised to pwer 'n'
   
    System.out.print("This is the sum of the array ");
    System.out.println(sum(array, 5));
    
    do
    {
    System.out.print("Enter a positive value for 'a': ");
     a = scan.nextInt();         
    
    System.out.print("Enter a positive value for 'n': ");
     n = scan.nextInt();
     
    aToPowerN = power(a,n);  // calling the method that computes a^n
    
    System.out.println(a + " raised to power " + n + " gives " + aToPowerN);
    
    System.out.print("\nanother run? (y/n) ");
    runAgain = scan.next();
    }
    while(runAgain.toLowerCase().equals("y"));
    
    
    System.out.println("End of program ");
}
 /*--------------------- print array methods-------------------------*/   
    public static void printArrayLeftRecursion(int [] array,int N)
    {
        if(N == 1)
        {
            System.out.println("Terminating condition left recursion");
            System.out.println(array[0]);
            return;
        }
        else
        {
            // additional operation
            System.out.println(array[N-1]+ " ");
            
            System.out.println("Call left recursion with N = " + (N-1));
               printArrayLeftRecursion(array,N-1);
            System.out.println("Exit left recursion with N = " + (N-1));
            
            return;
        }
    }
    
    public static void printArrayRightRecursion(int [] array,int N)
    {
        if(N == 1)
        {
            System.out.println("Terminating condition right recursion");
            System.out.println(array[0]);
            return;
        }
        else
        {
            
            System.out.println("Call right recursion with N = " + (N-1));
                printArrayRightRecursion(array,N-1);
            System.out.println("Exit right recursion with N = " + (N-1));
            
            // additional operation
                System.out.println(array[N-1]+ " ");
            return;
        }
    }
    /*--------------------method power: Compute a^n--------------------------------*/
    public static int power(int a, int n)
    {  
    		//Definition
    		//a^0 = 1;
    		//a^n = a^(n-1) * a;
        
    		//terminating condition
    		if(n == 0)
    		{
    			return 1;
    		}
       // recursive part
    		else
    		{
    			return power(a, n - 1) * a;
    		}
    }
    
    public static int sum(int array[], int N)
    {
    		//Definition
    		
    		//Terminating Condition
    		if(N==1)
    		{
    			return array[0];
    		}
    		//Recursive RUle
    		else
    		{
    			return sum(array, N-1) + array[N-1];
    		}
    }
} // end of class
