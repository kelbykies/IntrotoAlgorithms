import java.util.Arrays;
import java.util.Scanner;

public class SpecifiedArrayPattern {

	public static void main(String[] args) {
		
		final Scanner input = new Scanner(System.in);
		System.out.println("Welcome! This program reads a number N, and then prints two triangles in an ascending and descending fashion.");
		System.out.print("Please enter an integer:");
		
		int size = input.nextInt();
		int [] [] ascending = new int[size][size];
		int [] [] descending = new int[size][size];
		
		
		for(int column = 0; column < size ; column++)
		{	
			for(int row = 0; row <= column; row++)
			{
				ascending[column][size - (row + 1)] = (row + 1);
			}
		}
		
		for(int row = (size - 1); row >= 0; row--)
		{
			int fill_size = size;
			
			for(int column = row; column >= 0; column --)
			{
				descending[row][column] = fill_size;
				fill_size--;
			}
		}
			
		for(int[] row: ascending)
		{
			for(int element : row)
			{
				if(element == 0)
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print(element);
				}
			}
			System.out.println();
		}
		
		
		for(int[] row : descending)
		{
			for(int element : row)
			{
				if(element == 0)
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print(element);
				}
			}
			System.out.println();
		}
		
		input.close();
	}

}
