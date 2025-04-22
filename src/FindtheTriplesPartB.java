import java.util.Scanner;

/**
 * Group 4: Problem# 3
 *	Find the Triples
 * 
 * The purpose of this algorithm is to find the first triple of numbers within an array with O(N^2) complexity.
 * 
class FindtheTriplesPartB 
Read in the size and elements of the array provided by the user.
Call the method findFirstTriple.
The array gets sorted by insertion sort.
Run through the array comparing each element to the element two indexes higher.
If they are equal return true.
If the loop runs through the whole array and no triples are found return false.
Print whether the array truly contains a triple or not.


Input: The user gives the size of the array.
The user provides the elements of the array.
Output: The output is YES if there are triples and the element whose triple is found first, NO otherwise. 

//end program
 * 
 *The analysis:
 The complexity is reduced to O(N^2) because an insertion sort is implemented. 
 The nested for loop, previously 3 nested loops, is reduced to two. 
 The length of the for loops is N.
 Therefore the complexity of the outside and inside loop is O(N). 
 The N's are multiplied together because it is a nested for loop.  

@author Kelby Kies
@version #3
@Date 11/8/2018 */

public class FindtheTriplesPartB {

	public static String findFirstTriple(int[] B)
	{
		int j, p, tmp;
		String result = "NO";
		
		for(p = 1; p < B.length; p++)				//insertion sort
		{
			tmp = B[p];
			for(j = p; j>0 && tmp < B[j-1]; j--)
			{
				B[j] = B[j-1];
			}
			B[j] = tmp;
		}
		
		for(int i = 0; i < B.length; i++)
		{
			for(int k = i + 2; k < B.length; k++)
			{
				if(B[i] == B[k])					//Compare elements
				{
					result = "YES, " + B[i];
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
			
			System.out.println(findFirstTriple(array));
			
			System.out.println("Do you want to run again.y/n ");		//Option to rerun the program
			continuation = input.next();								//reads the user's decision
		}
		
		while(continuation.equals("y"));		//checks the user's decision
		System.out.println("End of Program.");		//Closing statement
	}
}
