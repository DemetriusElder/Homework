import java.util.Iterator;
import java.util.NoSuchElementException;
/** This is HW4. 5/10/2022
 * This class implements List.
 * This Linked List will create a series of nodes and link them together.
 * As well perform a various other functions such as adding, removing, and smaller functions.
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class LinkedList<T> implements List<T> {
	/*
	 * The list of private variables
	 * Head and Tail to keep track of the beginning and end of the linked list
	 * size to keep track of how big the list has grown
	 */
	private Node head = new Node();
	private Node tail = new Node(); 
	private int size; 
	/**
	 * The node creation class. This is how we store the data and create the links.
	 * Prev and Next are essentially the links to nearby nodes.
	 * data is the actual information stored in the node.
	 */
	public class Node {
		private Node next;
		private Node prev;
		T data;

	}
	/**
	 * the add(item) is supposed to add the item to the end of a list
	 * since I already have a similar method I use constructor chaining.
	 * @param item
	 */
	@Override
	public void add(T item) {
		this.addLast(item);
	}
	/**
	 * the clear() is supposed to clear the entire Linked List
	 * It achieves this by using a for loop to go through the list and setting all values to null
	 */
	@Override
	public void clear() {
		for (Node i = head; i!=null; ) {
			Node nextNode = i.next;
			i.next = null;
			i.prev = null;
			i.data = null;
			i = nextNode;
		}

	}
	/**
	 * the contain(item) is supposed to search the array for a certain item
	 * it achieves this by going through the entire list while the next node does not equal node
	 * and then counts how many instances of item there are
	 * if it didnt count anythign it'll return false otherwise itll return true
	 * @param item
	 * @return boolean false or true
	 */
	@Override
	public boolean contains(Object item) {
		int x = 0;
		for (Node i = head; i!=null; ) {
			Node nextNode = i.next;
			if(i.data == item)
			{
				x++;
			}
			i = nextNode;
			
		}
		if (x == 0)
			return false;
		else
			return true;
	}
	/**
	 * the isEmpty() is supposed to simply return a boolean based on size value
	 * if size is still zero then its empty if not then its not empty
	 * @return boolean true or false
	 */

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * the remove(item) is expected to remove an item from the list
	 * it achieves this by first looking for the node that conatins the object
	 * then based on where the item is located removes it and unlinks it from adjacent nodes
	 * @param item
	 * @return null
	 */

	@Override
	public T remove(Object item) {
		Node x = head;
		while (x.data != item && x.next !=null)
		{
			Node nextNode = x.next;
			x = nextNode;
			
		}	
		if (x == head)
			removeFirst();
		else if (x == tail)
			removeLast();
		else {
			x.prev.next = x.next;
			x.next.prev = x.prev;
		}
		return null;
		
	}
	/**
	 * the size() simply is supposed to return the size value
	 * @return size
	 */

	@Override
	public int size() {
		return this.size;
	}
	/**
	 * This is the personal Iterator methods to work with nodes
	 * @return testIterator
	 */

	@Override
	public Iterator<T> iterator() {
		Iterator <T> testIterator = new Iterator<T>() {
			private Node bookmark = head;
			private int count = 0;
			/**
			 * the hasNext simply checks if the next node is empty or not.
			 */
			@Override
			public boolean hasNext() {
				return bookmark.next != null;
			}
			/**
			 *  the next simply moves you over to the next node
			 *  @return null
			 */

			@Override
			public T next() {
				bookmark = bookmark.next;
				System.out.println(bookmark.data);
				count++;
				return null;
			}
			/**
			 * the remove() method is very similar to the remove method for Nodes
			 * the only difference is the internal tracker going on while it does this
			 */
			public void remove() {
				Node x = head;
				for (int i = 0; i < count; i++)
				{
					Node nextNode = x.next;
					x = nextNode;
					
				}	
				if (x == head)
					removeFirst();
				else if (x == tail)
					removeLast();
				else {
					x.prev.next = x.next;
					x.next.prev = x.prev;
				}
				count--;
				size --;
		    }
		};
		return testIterator;
	}
	/**
	 * the add(item,index) adds an item anywhere on the linked list
	 * it does this by first moving to the correct index then creating a new node
	 * this new node is then linked to the nearby nodes and their old nodes
	 * that used to link to each other are removed
	 * if there are no other node it simly chains to addFirst(item)
	 * if the size of the linked list is equal to the index then it chains to addLast(item)
	 * @param item
	 * @param index
	 * @throws IndexOutofBoundsException
	 */

	@Override
	public void add(T item, int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			addFirst(item);
		else if (index == this.size)
			addLast(item);
		else {
			Node sNode = head;
			Node nextNode = head.next;
			for (int i = 0; i < index; i++) {
				nextNode = sNode.next;
				sNode = nextNode;
			}
			Node x = new Node();
			x.data = item;
			x.prev = sNode.prev;
			x.next = sNode;
			sNode.prev.next = x;
			sNode.prev = x;
		}
		size++;
	}
	/**
	 * the get(index) is supposed to return he information stored in the node at index
	 * it does this by parsing through the list then retrieving the data value at that node
	 * @param index
	 * @return x.data
	 * @throws IndexOutOfBoundsException
	 */

	@Override
	public T get(int index) {

		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else {
		Node x = head;
		for (int i = 0; i < index; i++)
		{
			Node nextNode = x.next;
			x = nextNode;
			
		}		
		return x.data;
		}
	}
	/**
	 * the indexOf(item) is supposed to retrived the position of item
	 * it does this by parsing through the list searching for the item
	 * once it finds it it stores the index and ends the loop
	 * returns -1 if it isnt an item in the list
	 * @param item
	 * @return -1
	 * @return y
	 */

	@Override
	public int indexOf(Object item) {
		int x = 0;
		int y = 0;
		for (Node i = head; y==0 && i!= null; ) {
			Node nextNode = i.next;
			if(i.data == item)
			{
				y = x;
			}
			i = nextNode;
			x++;	
		}
		if (y == 0)
			return -1;
		else
			return y;
	}
	/**
	 * the remove(index) is supposed to remove the node at index
	 * it achieves this by first parsing through the list until it reaches the index
	 * it will then remove the item and unlink the node from nearby nodes
	 * and then it will link those adjacent nodes to each other
	 * @param index
	 * @return null
	 * @throws IndexOutOfBoundsException
	 */

	@Override
	public T remove(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		Node x = head;
		for (int i = 0; i < index; i++)
		{
			Node nextNode = x.next;
			x = nextNode;
			
		}	
		if (x == head)
			removeFirst();
		else if (x == tail)
			removeLast();
		else {
			x.prev.next = x.next;
			x.next.prev = x.prev;
		}
		size--;
		return null;
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		else
			return head.data;
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		if (tail == null)
			throw new NoSuchElementException();
		else
			return tail.data;
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		Node newNode = new Node();
		if(head.data == null) {
			newNode.data = item;
			head = newNode;
			newNode.next = tail;
			tail = newNode;
		}
		else {
			newNode.data = item;
			newNode.next = head;
			head = newNode;
			newNode.next.prev = head;
		}
		this.size++;

	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		Node newNode = new Node();
		if(head.data == null) {
			newNode.data = item;
			head = newNode;
			head.next = newNode;
			tail = newNode;
			tail.prev = newNode;
		}
		else {
			newNode.data = item;
			newNode.prev = tail;
			tail = newNode;
			newNode.prev.next = tail;
		}
		this.size++;

	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		if (size ==0)
			throw new NoSuchElementException();
		else if (size == 1)
		{
			head = null;
			tail = null;
		}
		else
		{
			head.next.prev = null;
			head = head.next;
		}
		size--;
		return null;
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		if (size ==0)
			throw new NoSuchElementException();
		else if (size == 1)
		{
			head = null;
			tail = null;
		}
		else
		{
			tail.prev.next = null;
			tail = tail.prev;
		}
		size--;
		return null;
	}
}