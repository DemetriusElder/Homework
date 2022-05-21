/** This is Stack and Queue Homework. 5/20/2022
 * This program is to act as the Queue class.
 * This class is filled with functions and constructors that serve to modify
 * and construct a Queued array by the rules first in first out.
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class Queue<V> 
{	/**
	* Initial private variables needed to correctly moderate the queued line.
	* Initial array serves as the 'line' for the queue.
	* Size acts to tell how many people are currently in 'line'
	*/
	private V[] initialArray;
	private int size;

    /**
    * Constructor to initialize the queue with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
    	this.initialArray = (V[]) new Object[maxSize];
    	return;
    }

    /**
        Returns the maximum size this queue can support.
    */
    public int getMaxSize() {
    	return initialArray.length;
    }

     /**
        Returns the current number of items enqueued.
    */
    public int getCurrentSize() {
    	return size;
    }

    /**
        Returns true if there are no elements in the queue.
        Simply iterates through the queue with a for loop and checks if any space is not null.
        if all null 0 = empty, if any not null x > 0 and it is not empty.
    */
    public boolean isEmpty() {
    	int x = 0;
    	for (int i = 0; i < size; i++)
    	{
    		if (initialArray[i] != null)
    			x++;
    	}
    	return x == 0;
    }

    /**
        Returns true if the queue is size is at max size.
        Same logic as is empty but reverse.
        Simply iterates through the queue with a for loop and checks if any space is null.
        if no null 0 = full queue, if any null x > 0 and it is not full.
    */
    public boolean isFull() {
    	int x = 0;
    	for (int i = 0; i < size; i++)
    	{
    		if (initialArray[i] == null)
    			x++;
    	}
    	return x == 0;
    }

    /**
        Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    */
    public V peek() {
    	return initialArray[0];
    }
    
   /**
        Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    */
    public void add(V value) {
    	if (size > initialArray.length)
    		throw new IllegalStateException();
    	else
    	{
    		this.initialArray[size] = value;
    		size ++;
    		System.out.println("True");
    	}
    }

    /**
        Retrieves and removes the head of this queue, or returns null if this queue is empty.
        simply if null returns null
        else it stores the first element and then goes through the queue moving every element left one.
    */
    public V poll() {
    	if (isEmpty() == true)
    	{
    		return null;
    	}
    	else
    	{
    		V temp = initialArray[0];
    		for(int i = 0; i < size; i++)
    		{
    			initialArray[i] = initialArray[i+1];
    		}
    		return temp;
    	}
    }
    
    /**
        Retrieves and removes the head of this queue.
        Same logic as poll but does not return null if empty.
    */
     public V remove() {
    	V temp = initialArray[0];
    	for(int i = 0; i < size - 1; i++)
 		{
 			initialArray[i] = initialArray[i+1];
 		}
    	initialArray[size-1] = null;
    	size --;
    	return temp;
    }
    
}