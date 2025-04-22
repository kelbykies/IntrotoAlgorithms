
/**
 *  BST_AVL_Compare 
 *  
 *  This class implements the user interface to conduct experiments 
 *  and compare the performance of BST and AVL trees.
 *  
 *  The user has two options: to test the trees with manually entered sequence of integers, 
 *  or with a randomly generated sequence of integers.
 *  
 *  Two trees are created and their height is printed. When the sequence is less than 30 numbers, 
 *  the sorted sequence and the preorder traversals are printed 

 * @author (Lydia Sinapova) 
 * @version (09/21/2015)
 */
import binTree_structures.*;
import java.util.*;
public class BST_AVL_Compare
{
   public static void main(String[] args)
    {     
        System.out.println("This program compares the performance of BST and AVL trees on integers");
        String answer = "y";
        int option;
        while(answer.equals("y"))
        {
        LinkedBinarySearchTree<Integer> treeBST = new LinkedBinarySearchTree<Integer>();    // declares BST
        AvlTree treeAVL = new AvlTree( );                                                   // declares AVL tree
        int count;
        Integer temp;
        int i;
   // user interface     
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose an option");
        System.out.println("   1: test sequence, manually entered");
        System.out.println("   2: array or randomly created integers");
        System.out.print("Enter your choice: ");
        option = scan.nextInt();
        
   // Test sequence entered manually
        if (option == 1)
        {
         int input= 0;
         System.out.println("Enter a sequence of positive numbers, -1 to end  ");
        
        while(input != -1)                  // a loop that inserts the entered integers in a BST and in an AVL tree
        {
           input = scan.nextInt();
           if(input != -1)
           {
           temp = new Integer(input);
           treeBST.addElement(temp);        
           treeAVL.insert(input);
           }
        }   
        }
   // Test sequence randomly generated
        else
        {
           System.out.print("How many element to insert? ");
           int numElements = scan.nextInt();  
           System.out.print("Enter upper bound of generated integers ");
           int upper = scan.nextInt();
           
           int [] array = createArray(numElements, upper);          // creates an array with random integers
           
           for (i = 0; i < numElements; i++)                        // a loop that inserts the entered integers in a BST and in an AVL tree 
           {
           temp = new Integer(array[i]);
           treeBST.addElement(temp);
           treeAVL.insert(array[i]);
           }
        }
         count = treeBST.size();
         System.out.println("Nodes created = " + count);
         
    // Printing the elements if less than 30
         if (count < 30)
         {
             System.out.println("BST sorted: ");
             treeBST.displayInOrder();
             System.out.println("\nAVL Tree sorted: ");
             treeAVL.printTree();
             System.out.println();
         
         System.out.println("BST in pre-order: ");
         treeBST.printTreePre();
         System.out.println("\n\nAVL tree in pre-order: ");
         treeAVL.printTreePre();
         }
     // Reporing the heights of the trees    
         System.out.println("\nHeight of the BST: " + treeBST.height());
         System.out.println("Height of the AVL: " + treeAVL.treeHeight());
         
         System.out.print("More? (y/n) : ");
         answer = scan.next();
        } // end while answer == y              
        System.out.println("End of program ");
       
    }// end main
  /*------------------ create Array ---------------------------------------------*/  
    public static int[] createArray(int size, int upper)   //fills an array with random numbers
    { 
        Random rnum = new Random();
        int [] array = new int[size];
        for(int i = 0; i < size; i++)
          {
                array[i] = rnum.nextInt(upper);
          } 
        return array; 
    }
}
