/**
 * Group 4: Problem# 2
 * Find two elements whose sum is S
 * 
 * The purpose of this algorithm is to find the first pair of integers within a user
 * given array whose sum is equal to the desire sum provided by the user.
 * 
import java.util.Arrays;
import java.util.Scanner;

public class Group4Problem2  {
public static void main(String[] args) {
String continuation //used to represent if the user wants to continue using the program.
final Scanner input = new Scanner(System.in);				//variable to represent the user's entry
//Welcome Message
System.out.println("Welcome! This program returns the elements whose sum is S.");
//Prompt to enter the size of the array
System.out.println("Please enter the size of the array: ");
int size	;			//User given size of the array
//Prompt to enter elements of the array
int[] userArray;		//Array created with the size and numbers given by the user
int number;	//Represents the number read in from the user to be put in the array
	
//Prompt to enter numbers for array
System.out.println("Please enter the positive integers of the array separated by a space: ");	

Input: The first line contains the number of elements in the array.
The second line contains the size of the array.
The third line contains the elements of the array separated by a space.

Output: The output is either 'The elements (integer 1) and (integer 2) have sum S or 'No two elements have the Sum S.


//Option to rerun the program
//end program
 * 
 *The analysis:
 The sort function has an average running time of O(NlogN) because it is a basic Quicksort. The while loop that checks for 2 elements whose sum
 is S has a run time of O(N) because in the worst case the loop will run for the entire size N of the array.
 Thus the overall runtime is NlogN because it is higher than O(N). 

@author Kelby Kies
@version #3
@Date 10/25/2018 */


import java.util.Arrays;
import java.util.Scanner;

public class Group4Problem2 {

	public static void main(String[] args) 
	{
		String continuation;					//used to represent if the user wants to continue using the program.
		
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome! This program returns the elements whose sum is S.");	//Welcome Message
			System.out.println("Please enter the sum: ");			//Prompt to enter sum
			int sum = input.nextInt();								//Variable that represents the sum
			System.out.println("How many elements in the sequence: ");	//Prompt to enter number of elements
			int size = input.nextInt();
			
			int[] userArray = new int[size];		//Array created with the size and numbers given by the user
			int number;							//Represents the number read in from the user to be put in the array
	
			System.out.println("Enter the elements in the sequence separated by a space: ");	//Prompt to enter elements of the array
			
			for(int i = 0; i < size; i++)
			{
				number = input.nextInt();
				userArray[i] = number;
			}
			
			
			Arrays.sort(userArray);		//sort the array
			
			int leftIndex = 0;
			int rightIndex = size - 1;
			int currentSum = 0;			
			boolean found = false;		//condition for while loop
			
			while(!found)
			{
			     currentSum = userArray[rightIndex] + userArray[leftIndex];

			     if(currentSum < sum)
			     {
				      leftIndex++;
			     }
			     else if(currentSum > sum)
			     {
				      rightIndex--;
			     }
			     else if(sum == currentSum)
			     {
				      System.out.println("The elements " + userArray[leftIndex] 
								+ " and " + userArray[rightIndex] + " have sum " + sum);
				      found = true;
			     }
	
				
				if(leftIndex == rightIndex)
				{
					System.out.println("No two elements have sum " + sum);
					found = true;
				}
				
			}
			
			System.out.println("Do you want to run again.y/n ");		//Option to rerun the program
			continuation = input.next();								//reads the user's decision
		}
		
		while(continuation.equals("y"));		//checks the user's decision
		System.out.println("End of Program.");		//Closing statement
	}
}
