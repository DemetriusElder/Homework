/** This is HW2. 5/04/2022
 * This program implements List.
 * Array List is a program to perform a multitude of functions to create a 'growing' array
 * It is still limited in it's default capacity but performs all other functions.
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version %I%
 */
public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private int size = 0;
	private T[] data;
	/**
	 * Constructs an ArrayList using the default capacity
	 */
	public ArrayList() {
		this.data =(T[]) new Object[ArrayList.DEFAULT_INITIAL_CAPACITY];
		return;
	}

	/**
	 * Constructs an ArrayList with an 'initialCapacity'
	 * 
	 * If 'initalCapacity' is non-positive use the default capacity
	 * 
	 * @param initialCapacity
	 */
	public ArrayList(int initialCapacity) {
		if (initialCapacity >=1)
			{
			this.data =(T[]) new Object[ArrayList.DEFAULT_INITIAL_CAPACITY];
			}
		else {
			this.data =(T[]) new Object[initialCapacity];
		     }
		return;
	}
	/**
	 * Adds a value to the array at point of the asked for index
	 * The secondary function is to keep track of the size of the array by adding one
	 * to the size variable
	 * @param item
	 * @param index
	 */
	@Override
	public void add(T item, int index) {
		this.data[index] = item;
		this.size++;
	}
	/*
	 * Clears the array by replacing all value with null
	 */
	@Override
	public void clear() {
		for(int i = 0; i < this.data.length;i++) {
			this.data[i] = null;
		}
	}
	/*
	 * returns true if array contains item and false if it does not
	 * it achieves this by going through the entire array and checks for item
	 * if it contains item it adds to variable x and then if x !=0 then it must contain item
	 * @param item
	 * @return false or true
	 */
	@Override
	public boolean contains(Object item) {
		int x = 0;
		for(int i = 0; i < this.data.length;i++) {
			if(this.data[i] == item) {
				x++;
			}
		}
		if(x == 0)
			return false;
		else
			return true;
	}
	/*
	 * Return the item at index if the index value provided is greater then 0 and less then the full length of the array
	 * otherwise return null
	 * @param index
	 * @return this.data[index] or null
	 */

	@Override
	public T get(int index) {
		if(index >= 0 && index < this.data.length)
			return this.data[index];
			else
				return null;
	}
	/*
	 * Searches the entire array for item by using a for loop
	 * then once it finds the item, if it finds it, sets x = to the index it was logged
	 * then returns x if its not zero and if it is 0, which mean the item is not in the array, returns -1
	 * @param item
	 * @return -1 or x
	 */
	@Override
	public int indexOf(Object item) {
		int x = 0;
		for(int i = 0; i < this.data.length;i++) {
			if(this.data[i] == item) {
				x = i;
			}
		}
		if (x == 0)
			return -1;
		else
			return x;
	}
	/*
	 * Checks the if the array is empty by checking it for null values
	 * if all null values are found x should still be zero otherwise its not empty
	 * @return true or false
	 */
	@Override
	public boolean isEmpty() {
		int x = 0;
		for(int i = 0; i < this.data.length;i++) {
			if(this.data[i] != null) {
				x++;
			}
		}
		if (x == 0)
			return true;
		else
			return false;
	}
	/*
	 * Tells the user the size of the array by recalling the size int
	 * @returns size
	 */
	@Override
	public int size() {
		return this.size;
	}
}