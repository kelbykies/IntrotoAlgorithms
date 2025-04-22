/**
 * Group 4: Problem# 3
 *	Find the Triples: Part C
 * 
 * The purpose of this algorithm is to find the first triple of numbers within an array with O(NLogN) complexity.
 * 
class FindtheTriplesPartC {
Read in the size and elements of the array provided by the user.
Call the method findFirstTriple.
The array gets sorted by Quicksort.
Run through the array comparing each element to the element two indexes higher.
If they are equal return true.
If the loop runs through the whole array and no triples are found return false.
Print whether the array truly contains a triple or not.

Input: The user provides the size of the array.
The user provides the elements of the array.
Output: The output is YES if there are triples and the element whose triple is found first, NO otherwise.

 * 
 *The analysis:
 The complexity is reduced to O(NLogN) because quicksort is implemented. 
 The nested for loop, previously 3 nested loops, is reduced to 1. 
 The length of the for loops is N.
 Therefore the complexity of the for loop is O(NLogN). 

@author Kelby Kies
@version #3
@Date 11/8/2018 */

import java.util.Arrays;
import java.util.Scanner;

public class FindtheTriplesPartC {
	public static String findATriple(int[] C)
	{
		String result = "NO";
		Arrays.sort(C);					//QuickSort
		for(int i = 0; i < C.length; i += 2)
		{
			if((C.length - i) > 2)
			{
				if(C[i] == C[i+2])			//Compare elements
				{
					result = "Yes, " + C[i];
				}
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		String continuation;
		
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("How many elements in the sequence: ");	//Prompt to enter number of elements
			int size = input.nextInt();
			
			int[] array = new int[size];		//Array created with the size and numbers given by the user
			int number;							//Represents the number read in from the user to be put in the array
			System.out.println("Enter the elements in the sequence separated by a space: ");	//Prompt to enter elements of the array
			
			for(int i = 0; i < size; i++)
			{
				number = input.nextInt();
				array[i] = number;
			}
			
			System.out.println(findATriple(array));
			System.out.println("Do you want to run again.y/n ");		//Option to rerun the program
			continuation = input.next();								//reads the user's decision
		}
		
		while(continuation.equals("y"));		//checks the user's decision
		System.out.println("End of Program.");		//Closing statement
			
	}

}
