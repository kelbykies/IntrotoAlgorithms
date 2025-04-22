/**
 * Group 1: Problem#4 
 * Door in a Wall
 * You are facing a wall that stretches infinitely in both directions. 
 There is a door in the wall, but you know neither how far away nor in which direction. 
 You can see the door only when you are right next to it.
 * The purpose of this code is to create an algorithm that enables you to reach the door by walking at most
 * O(n) steps where n is the (unknown to you) number of steps between your initial position and the door.
 * 
import java.util.Scanner;

public class Group1Homework4  {
public static void main(String[] args) {
String continuation //used to represent if the user wants to continue using the program.
final Scanner input = new Scanner(System.in);				//variable to represent the user's entry
//Welcome Message
System.out.println("Welcome! This program sets the position of a secret door and calculates the amount of steps to find the door.");
System.out.println("Please enter an integer for the location of door:");

int door = input.nextInt();						//variable to represent the user's entry
int difference;			//variable to represent the difference between person's position and door position
int total;				//total amount of steps
int position;			//person's position
int increment;			//the amount incremented along 
boolean found;			//variable that represents if door is found

Input: An integer representing the number of steps between you and the door.
Output: “The door was found in X steps” where X is the number of steps you have walked to find the door.

//Option to rerun the program
//end program
 * 
 *The analysis has two parts:
The number of steps to find the door is O(N).
As the person moves back and forth to search for the door, his increment increases by a multiple of 2 each time.
The sum of the steps would equal 1 + 2 + 4 + 8...N. Which is equal to 2N-1.

The running time of the program is O(log(N)).
The loop variable that records the length of one move left or right is multiplied by 2
@author Kelby Kies
@version #1
@Date 10/4/2018 */

import java.util.Scanner;
public class Group1Homework4 {
	
	public static void main(String[] args) 
	{	
		String continuation;					//used to represent if the user wants to continue using the program.
		
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome! This program sets the position of a secret door"
								+ " and calculates the amount of steps to find the door.");		//Welcome Message
			System.out.println("Please enter an integer for the location of door:");
			
			int door = input.nextInt();						//variable to represent the user's entry
			int difference;									//variable to represent the difference between person's position and door position
			int total = 0;									//total amount of steps
			int position = 0;								//person's position
			int increment = 1;								//the amount incremented along 							
			boolean found = false;							//variable that represents if door is found
		
			if(door == 0)
			{
				System.out.println("Door was found in 0 steps.");	
			}
			
			else
			{
				while(!found)
				{
					total += Math.abs(increment);			//adding the total steps
					position = position + increment;			//person moving
					
					if(position > 0 && door > 0)		//Check to see if the person and door are on the right side of start position
					{
						if(position >= door)		//Check to see if person has past or is standing at door
						{
							found = true;		
						}
					}
					
					else if(position < 0 && door < 0)	//Check to see if the person and door are on the left side of start position
					{
						if(position <= door)				//Check to see if person has past or is standing at door
						{
							found = true;
						}
					}
					
					increment = increment * (-2); 		//Increase the Increments to find the door quicker
				}
				
				difference = position - door;			//find the difference between the persons position 
				total = total - Math.abs(difference);	//adding the total steps
	
				System.out.println("Door was found in " + total + " steps.");		//Prints the persons total steps to find the door
			}
			
		System.out.println("Do you want to run again.y/n ");		//Option to rerun the program
		continuation = input.next();								//reads the user's decision
		}
		
		while(continuation.equals("y"));		//checks the user's decision
		System.out.println("End of Program.");		//Closing statement
	}
}
