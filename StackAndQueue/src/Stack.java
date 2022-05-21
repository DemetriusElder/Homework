/** This is Stack and Queue Homework. 5/20/2022
 * This program is to act as the Stack class.
 * This class is filled with functions and constructors that serve to modify
 * and construct a Stacked array by the rules first in last out.
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class Stack<V>
{
	private V[] initialArray;
	private int size;

    /**
        Constructor to initialize the stack with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")
    public Stack(int maxSize)
    {
    	this.initialArray = (V[]) new Object[maxSize];
    	return;
    }
 
    /**
         Pushes an item onto the top of this stack.
    */
    public void push(V element) {
    	initialArray[size] = element;
    	size++;
    }
 
    /**
        Removes the object at the top of this stack and returns that object as the value of this function.
    */
    public V pop()
    {
    	V temp = initialArray[size-1];
    	initialArray[size-1] = null;
    	size --;
    	return temp;
    	
    }
 
    /**
        Looks at the object at the top of this stack without removing it from the stack.
    */
    public V peek()
    {
    	return initialArray[size-1];
    }
 
    /**
        Returns the number of items currently in the stack
    */
    public int currentSize() 
    {
    	return size;
    }
 
    /**
        Tests if this stack is empty.
    */
    public boolean isEmpty() 
    {
    	int x = 0;
    	for (int i = 0; i < size; i++)
    	{
    		if (initialArray[i] != null)
    			x++;
    	}
    	return x == 0;
    }
 
    /**
        Tests if this stack is full
    */
    public boolean isFull() 
    {
    	return initialArray[initialArray.length] != null;
    }
    
}