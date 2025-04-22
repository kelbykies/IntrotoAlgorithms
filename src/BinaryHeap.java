
/**
 * BinaryHeap Class.
 * 
 * public BinaryHeap(Comparable [] items)
 * public BinaryHeap(int size)
 * 
 * public void insert(Comparable x)
 * public Comparable deleteMin() throws EmptyHeapException
 * private void buildHeap()
 * private void percolateUp(Comparable x)
 * private void percolateDown(int hole) 
 * private void enlargeArray(int newSize)
 * public void  displayHeap()
 * 
 * @author (Weiss) 
 * @version (10/03/07)
 */
public class BinaryHeap 
{
    private Comparable [] array ;
    private int currentSize;
 
/*------------------------------------CONSTRUCTOR --------------------------*/
   public BinaryHeap(Comparable [] items)   // array given
   {
     currentSize = items.length;
     array =   new Comparable [currentSize + 1];
     
     int i = 1;
     for( Comparable item: items)
       array[i++] = item;
     
     buildHeap();
    }
   public BinaryHeap(int size)           // array not given
   {
      array =  new Comparable[size + 1];
      currentSize = 0;
   }
/* ------------------------------ METHODS of the class ---------------------*/
  
    public void insert(Comparable x)
    {
       
        if(currentSize == array.length -1)
            enlargeArray(array.length*2 +2);
       
        percolateUp(x);
    }
  /*-------------------------------------DELETE MIN --------------------------*/
   public Comparable deleteMin() 
   {
   if(isEmpty()) throw new EmptyHeapException();
   
   Comparable min_el = array[1];         // element to be returned
   array[1] = array[currentSize--];      // move the last element at the top, 
                                         // required by the percolateDown method
                     
   percolateDown(1);                     // percolate down the hole
   return min_el;                        // return the max element
   }
 
 /*--------------------Queue EMPTY ---------------------*/
  public boolean isEmpty()
  {
   return (currentSize == 0);
  }
 
/*=========================PRIVATE METHODS====================*/
 /*------------------------build heap -------------------------*/
 private void buildHeap()
 {
   for (int i = currentSize/2; i > 0; i--)
     percolateDown(i);
 }
 /*-------------------------percolate up------------------------*/
   private void percolateUp(Comparable x)
   {
    int hole = ++currentSize;     // increase current size and create a hole
    for( ; hole > 1 && x.compareTo (array[hole/2]) < 0; hole = hole /2)
            array[hole] = array[hole/2];
    array[hole] = x;
    }
   
 /*----------------------- percolate down ----------------------*/   
     private void percolateDown(int hole)   
    {
 
        int child;
        Comparable tmp = array[hole];  
         
        for( ; hole*2 <= currentSize; hole = child)
        {
            child = hole * 2;
            if( child != currentSize &&     // select the smaller child
                array[child+1].compareTo( array[child]) < 0)
                    child++;
            if( array[child].compareTo(tmp) < 0)  // child is with higher priority
                array[hole] = array[child];       // move child up, hole - down
            else
               break;  // found position to insert 
        }
        array[hole] = tmp;
    }
 /*------------------Assign Top Element------------------*/
     public Integer getTopElement() 
     {
    		return (Integer) array[1];
     }
 
 
   /*----------------------enlarge array ---------------*/
 private void enlargeArray(int newSize)
 {
    Comparable [] newArray =  new Comparable[newSize];
    
    for(int i = 1; i <= currentSize; i++)
    {
       newArray[i] = array[i];
    }
    array = newArray;
 }
    
/*==============================ADDITIONAL====================================*/ 


/*-----------------------------DISPLAY ARRAY ---------------------------------*/

 public void  displayHeap()
 {
   for (int i = 1; i <=currentSize; i++)
     System.out.print(array[i].toString() + ", ");
   System.out.println();
 }
 }

