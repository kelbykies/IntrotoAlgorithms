/**
 * Group 2: Problem# 5
 *	The virus attack
 * 
 * Purpose:
 * In a controlled environment, there is 1 virus and N bacteria. Each time they reproduce,the virus duplicates
 * and the bacteria decrease by the amount of viruses there are (because those virus kill of 1 bacteria each) and then duplicate.
 * The purpose of this algorithm is to determine how many steps it takes to kill N bacteria beginning with 1 virus.

import java.util.Scanner;

class VirusAttack 
 PseudoCode:
	Ask the user for how many bacteria to begin with (N).
	The method, attackBaceria, is called from the main class with the starting number of bacteria (N), 1 virus and 0 steps.
	attackBacteria checks to see if all of the bacteria are killed. 
	If they are the amount of steps it takes to kill all of the bacteria is printed.
	If they aren't then the steps increment by 1.The starting amount of bacteria is decremented by the amount of viruses and then doubled.
	The starting amount of viruses is doubled.
	attackBacteria is recursively called with the new populations of virus and bacteria.

Input: an integer n representing the number of bacteria.
Output: The number of steps that it takes for the virus to kill all bacteria.

//Option to rerun the program
//end program
 * 
 * How does the running time of your algorithm depend on n?
 * The bacteria is being in N steps due to the growth of the viruses. The program has O(N) complexity because  
 * there are N steps of the method being called recursively. 

@author Kelby Kies
@version #2
@Date 11/4/2018 */

import java.util.Scanner;

public class VirusAttack {

	public static void attackBacteria(int startingVirus, int startingBacteria, int count)
	{
		if(startingBacteria <= 0)
		{
			System.out.println("It took " + count + " steps to kill the bacteria.");	//Output Message
		}
		
		else
		{
			System.out.println(startingVirus + " " + startingBacteria);
			count++;
			startingBacteria = startingBacteria - startingVirus;
			startingVirus *= 2;
			startingBacteria *= 2;
			attackBacteria(startingVirus, startingBacteria , count);		//Recursive call after each step
		}
	}
	
	public static void main(String[] args) {
		String continuation;
		do
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome! This program returns the number of steps that it takes for 1 virus to attack N bacteria. ");	//Welcome Message
			System.out.println("Please enter the number of bacteria: ");
			int bacteria = input.nextInt();			//User given amount of bacteria
			int virus = 1;							//The program begins with 1 virus
			int steps = 0;							//The least amount of steps it will take is 1
			attackBacteria(virus, bacteria, steps);
			
			System.out.println("Do you want to run again.y/n ");		//Option to rerun the program
			continuation = input.next();								//reads the user's decision
		}
		
		while(continuation.equals("y"));		//checks the user's decision
		System.out.println("End of Program.");		//Closing statement
	}

}
