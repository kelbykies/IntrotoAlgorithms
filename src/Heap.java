/**
 * Group 3: Problem# 3
 * Is it a binary Heap?
 * 
 * The purpose of this algorithm is to determine whether the array given by the user of
 * N positive integers is a binary heap or not. Assume that smaller integers indicate a higher priority.
 * 
import java.util.Scanner;

public class Heap  {
public static void main(String[] args) {
String continuation //used to represent if the user wants to continue using the program.
final Scanner input = new Scanner(System.in);				//variable to represent the user's entry
//Welcome Message
System.out.println("Welcome! This program indicates whether a user given array classifies as a binary heap.");
//Prompt to enter the size of the array
System.out.println("Please enter the size of the array: ");
int size	;			//User given size of the array
int[] userArray;		//Array created with the size and numbers given by the user
int number;	//Represents the number read in from the user to be put in the array
int count;	//Keeps count on if the indicated node is a lower priority then its parent node.
	
//Prompt to enter numbers for array
System.out.println("Please enter the positive integers of the array separated by a space: ");	

Input: The first line contains the number of elements in the array.
The second line contains the elements of the array separated by a space.

Output: The output is “YES” if the entered array is a binary heap, “NO” otherwise.

//Option to rerun the program
//end program
 * 
 *The analysis:
 *The programs runtime is O(N) because the for loop used to create the array has a runtime of O(N).
 *The for loop used to compare the elements has a runtime of O(N). 

@author Kelby Kies
@version #3
@Date 10/25/2018 */


import java.util.Scanner;

public class Heap {

	public static void main(String[] args) 
	{
		String continuation;					//used to represent if the user wants to continue using the program.
		
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome! This program indicates whether a user given array classifies as a binary heap.");		//Welcome Message
			System.out.println("Please enter the size of the array: ");		//Prompt to enter the size of the array
			int size = input.nextInt();			//User given size of the array
			
			int[] userArray = new int[size + 1];		//Array created with the size and numbers given by the user
			int number;							//Represents the number read in from the user to be put in the array
			String result = "YES";
			
			System.out.println("Please enter the positive integers of the array separated by a space: ");		//Prompt to enter numbers for array
			
			for(int i = 1; i < (size + 1); i++)
			{
				number = input.nextInt();
				userArray[i] = number;
			}
			
			
			for(int index = size; index > 1; index--)
			{
				if(userArray[index] < userArray[(index/2)])
				{
					index = 1;
					result = "NO";
				}
			}
		
			System.out.println(result);
			
			System.out.println("Do you want to run again.y/n ");		//Option to rerun the program
			continuation = input.next();								//reads the user's decision
		}
		
		while(continuation.equals("y"));		//checks the user's decision
		System.out.println("End of Program.");		//Closing statement
	}
}
