/**
 * Group 1: Problem#1 
 * Rectangles Non-Recursive
 * 
 * The purpose of this code is to create a 2-dimensional 
 * table using a non-recursive algorithm given user provided dimensions.
 * The result is sub-boxes of numbers beginning with 1 on the outer edge
 *  and decreasing until there are no boxes left. 
 
import java.util.Scanner;

public class RectanglesNonRecursive {
//function that resets each element in the rectangle array to 0.
 * 
public static void main(String[] args) {
String continuation //used to represent if the user wants to continue using the program.
final Scanner input = new Scanner(System.in);				//variable to represent the user's entry
//Welcome Message
System.out.println("Welcome! Please enter two digits separated by a space. Press return when finished: ");

int width		//represents the width dimension of rectangle
int length		//represents the length dimension of rectangle
int [] [] rectangle;		//2D array created with users dimensions			
int count;						//represents the number to be entered into the rectangle array
int max_entry;  //determines how far count increases

Input to the program: two integers representing the number of rows and the number of columns in the 2D array
Fill the rectangle array with the pattern below with count starting at one 
and ending on half of the smallest dimension.

A[0][0] to a[0][m-count] = count		//top row
//fill the top row of the array with numbers.
A[n-1][0] to a[n-1][m-count] = count	//bottom row
//fill the bottom row of the array with numbers.
A[0][0] to a[n-1][0] = count ///left column
//fill the left column with numbers
A[0][m-1] to a[n-1][m-count] = count	//right column
//fill the right column with numbers.

Output: print the 2D array
1 1 1 1 1 1 1 
1 2 2 2 2 2 1 
1 2 3 3 3 2 1 
1 2 2 2 2 2 1 
1 1 1 1 1 1 1
//Option to rerun the program
//end program

@author Kelby Kies
@version #2
@Date 9/6/2018 */


import java.util.Scanner;

public class RectanglesNonRecursive {
	
	public static void resetArray(int[][] array, int row_length, int column_length)
	{
		for(int i = 0; i < row_length; i++)
		{
			for(int j = 0; j < column_length; j++)
			{
				array[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) 
	{
		String continuation;					//used for users request of multiple runs
		
		do{
			final Scanner input = new Scanner(System.in);				//variable to represent the user's entry
			
			//Welcome Message
			System.out.println("Welcome! This program takes two numbers to use as width and length in order to create a rectangle with those dimensions."); 
			System.out.println("Please enter two positive digits, representing the row and width of the rectangle, seperated by a space. Press return when finished: ");
			
			int width = input.nextInt();				//represents the width dimension of rectangle
			int length = input.nextInt();			//represents the length dimension of rectangle
			int [] [] rectangle = new int[width][length];				
			int count = 1;						//represents the number to be entered into the rectangle array
			int max_entry = Math.min((width + 1)/2, (length + 1)/2);		//determines how far count increases
			
				for(count = 1; count <= max_entry; count++)
				{
					int top_row = count - 1;			//represents the position of the top row 
					int bottom_row = width - count;	//represents the position of the bottom row
					int left_column = count - 1;		//represents the position of the left column
					int right_column = length - count; //represents the position of the right column
					
					for(int i = count - 1; i <= right_column; i++)
					{
						rectangle[top_row][i] = count; //filling in the top row
					}
					
					for(int k = count - 1; k <= right_column; k++)
					{
						rectangle[bottom_row][k] = count; //filling in the bottom row
					}
				
					for(int j = count - 1; j <= bottom_row; j++)
					{
						rectangle[j][left_column] = count; ///filling in the left column
					}
					
					
					for(int m = count - 1; m <= bottom_row; m++ )
					{
						rectangle[m][right_column] = count; //fill in the right column
					}
				}
			
			
			for(int[] row : rectangle)			//print the array
			{
				for(int element : row)
				{
					System.out.print(element + " ");
				}
				System.out.println();
			}
			
			//asks the user if they want to reset the algorithm
			System.out.println("Would you like to build another rectangle?y/n ");
			continuation = input.next();		//reads the user's decision
			resetArray(rectangle, width, length);			//resets the array
		}

		while(continuation.equals("y"));		//checks the user's decision
		System.out.println("End of Program.");		//Closing statement
	}

}
