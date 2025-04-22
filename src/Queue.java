/**
 * Queue class implemented as a circular array
 * 
 * Constructor: 
 *      public Queue(int size)
 * Methods:
 *      public void enQueue (int element)
 *      public int deQueue ()
 *      public boolean isEmpty()
 *      public boolean isFull()
 *      private void enlarge()
 */
public class Queue
{
    private int size;         // size of the array       
    private int [] array;     // circular array for the queue elements     
    private int start;        // position to read from
    private int end;          // position to write
    private int count;        // number of elements in the queue
 /*----------------------- constructor --------------------*/   
    public Queue(int size)
    {
        this.size = size;
        array = new int[size];
        start = 0;
        end = 0;
        count = 0;
    }
/*------------------------enQueue -------------------------*/
    public void enQueue (int element)
    {  
        if(isFull()) enlarge();
        
          array[end] = element;
          end = (end+1)%size;
          count ++;
         
           
    }
/*------------------------deQueue -------------------------*/
    public int deQueue ()
    {
        int element = array[start];
        start = (start+1)%size;
        count --;
        return element;
    }
/*------------------------isEmpty--------------------------*/
    public boolean isEmpty()
    {
        return count == 0;
    }
/*-----------------------isFull----------------------------*/
    public boolean isFull()
    {
        return count == size;
    }
/*-----------------------enlarge capacity of the array-----------------------*/    
    private void enlarge()
        {
           int [] newQueue = new int[size*2];
           int k = start;
           int j;
           for(j = 0 ; j < count; j++)
           {
               newQueue[j] = array[k];
               k = (k+1)%size;
           }
           start = 0; 
           end = j;
           size = size*2;
           array = newQueue;
        }
}
