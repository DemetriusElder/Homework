import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/** This is HashTable Homework. 5/20/2022
 * This program is to act as the LinearProbingHashTable class.
 * This class is filled with functions and constructors that create the hashtable
 * and modifies it accordingly.
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	/**
	 * Variables needed in all classes
	 * size is the amount of elements actually in the table
	 * capacity is the length of the array
	 * loadFactor is the limit ratio before we have to increase the array
	 */
	private int size = 0;
	private int capacity;
	private double loadFactor;
	private  HashTableEntry<K,V>[] entryArray;
	/**
	 * Constructor that calls the (int, double) since no declaraion
	 * set default as 11 size and 0.75 double
	 */
	public LinearProbingHashTable(){
		this(11,0.75);
	}
	/**
	 * Constructor that calls the (int, double) since only size declared
	 * set default as 0.75 double
	 * @param size
	 */
	public LinearProbingHashTable(int size){
		this(size,0.75);
	}
	/**
	 * Constructor that sets up the hashtable array
	 * initializes the capacity, loadfactor, and the entryArray.
	 * @param size , loadFactor
	 */
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int size, double loadFactor){
		this.capacity = size;
		this.loadFactor = loadFactor;
		this.entryArray = new HashTableEntry[size];
	}
	/**
	 * Clears the entire array
	 * Sets the size and capacity to zero and iterates through the array setting each element to null
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void clear() {
		this.size = 0;
		this.capacity = 0;
		try{
			for (int i = 0; i < entryArray.length; i++)
			entryArray[i] = null;
		}catch (UnsupportedOperationException e) {		 
	    }
	}
	/**
	 * Checks the array for a certain key
	 * simply checks the the element where the key should be located if the key is null or not
	 * returns null if the exceptions are thrown
	 * @param arg0
	 * @return boolean 
	 * @throws ClassCastException , NullPointerException
	 */
	@Override
	public boolean containsKey(Object arg0) {
		try{
			return entryArray[arg0.hashCode()%capacity].getKey() != null ;
		} catch (ClassCastException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}
	/**
	 * Checks the array for a certain value
	 * iterates through the the entire array searching for the value
	 * returns null if the exceptions are thrown
	 * @param arg0
	 * @return boolean
	 * @throws ClassCastException , NullPointerException
	 */
	@Override
	public boolean containsValue(Object arg0) {
		 int x = 0;
		 for (int i = 0; i < capacity; i++)
		 {
			 try {
			 if (entryArray[i].getValue() == arg0)
				 x++;
			 } catch(NullPointerException e) {
				 
			 } catch (ClassCastException e) {
				 
			 }
		 }
		return  x != 0;
	}
	/**
	 * Iterates through the set collection and adds elements from the entryArray to the set
	 * @return test
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> test = new HashSet<Map.Entry<K, V>>();
		for (int i = 0; i < capacity; i++)
			if (entryArray[i] != null)
				test.add(entryArray[i]);
		return test;
	}
	/**
	 * 
	 */
	@Override
	public V get(Object arg0) {
		if (entryArray[arg0.hashCode()%capacity].getKey() != null)
			return (V) entryArray[arg0.hashCode()%capacity].getValue();
		else
			throw new NullPointerException();
	}
	/**
	 * iterates through the array simply checking if the element is not empty
	 * if it is empty x should still be 0 if its not x != 0
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		int x = 0;
		for(int i = 0; i < capacity ; i++)
			if (entryArray[i] != null)
				x++;
		return x == 0;
	}
	/**
	 * creates a set and iterates through the entryArray adding each element to the set
	 * @return test
	 */
	@Override
	public Set<K> keySet() {
		Set<K> test = new HashSet<K>();
		for (int i = 0; i < capacity; i++)
		{
			if (entryArray[i] != null)
				test.add(entryArray[i].getKey());
		}
		return test;
	}
	/**
	 * This function does a few things
	 * Firstly it checks if the number of elements has reached above the loadFactor
	 * if it has it creates a new array but bigger copies all known elements and then sets entryArray to the new array
	 * 
	 * Secondly it adds the element to the entryArray
	 * if the provided key is not null and the element is empty it simply adds it
	 * 	also adds one to the size
	 * if the provided key is not null but the element is not null it checks if it is available
	 * 	if it is available it replaces the element
	 * if the provided key is not null and the element is not null and not available it iterates through the array for an empty space
	 * 	it iterates by simply moving to the next element and then replacing the current element
	 * @param key, value
	 * @return null , value
	 * @throws NullPointerException , ClassCastException , IllegalArgumentException , UnsupportedOperationException
	 */
	@Override
	public V put(K key, V value) {
		HashTableEntry<K,V> newOne = new HashTableEntry<K, V>(key,value);
		HashTableEntry<K,V> temp = new HashTableEntry<K, V>(key,value);
		try {
		if((double)size / capacity > loadFactor) {
		@SuppressWarnings("unchecked")
		HashTableEntry<K,V>[] tempArray = new HashTableEntry[capacity*2];
		for (int i = 0; i < entryArray.length; i++)
			tempArray[i] = entryArray[i];
		entryArray = tempArray;
		this.capacity = entryArray.length;
		}
		if (key != null && entryArray[key.hashCode()%capacity] == null)
		{
			entryArray[key.hashCode()%capacity] = newOne;
			size++;
		}
		else if (key != null && entryArray[key.hashCode()%capacity] != null && entryArray[key.hashCode()%capacity].isAvailable() == true)
		{
			temp = entryArray[key.hashCode()%capacity];
			entryArray[key.hashCode()%capacity] = newOne;
			return temp.getValue();
		}
		else if (key != null && entryArray[key.hashCode()%capacity] != null && entryArray[key.hashCode()%capacity].isAvailable() == false)
		{
			int x = 0;
			while (entryArray[key.hashCode()%capacity + x] != null && entryArray[key.hashCode()%capacity + x].isAvailable() == false) {
				x++;
			}
			entryArray[key.hashCode()%capacity + x] = newOne;
			size++;
			return temp.getValue();
		}
		} catch(NullPointerException e) {
			 
		} catch (ClassCastException e) {
			 
		} catch(IllegalArgumentException e) {
			 
		} catch (UnsupportedOperationException e) {
			 
	 }
		return null;
	}
	/**
	 * adds all the elements from a given map to the array
	 * iterates through the map and calls the put method with the param of the elmenets key and value
	 * @param otherMap
	 * @throws  NullPointerException , ClassCastException , UnsupportedOperationException , IllegalArgumentException
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		try{
			for (Entry<? extends K, ? extends V> pair : otherMap.entrySet()) {
		    this.put(pair.getKey(), pair.getValue());
		}
		} catch(NullPointerException e) {
		} catch (ClassCastException e) {
		} catch (UnsupportedOperationException e) {
		} catch (IllegalArgumentException e) {
		}	
		
	}
	/**
	 * removes a certain key from the table
	 * iterates through the entire array searching for the key and then removes it
	 * 	for loop in case of multiple instances of matching keys
	 * @param key
	 * @return temp.getValue , null
	 * @throws NullPointerException , ClassCastException , UnsupportedOperationException
	 */
	@Override
	public V remove(Object key) {
		try {
		for (int i = 0; i < entryArray.length; i++) {
		if (key != null && entryArray[i] != null && entryArray[i].getKey() == key)
		{

			HashTableEntry<K,V> temp = entryArray[key.hashCode()%capacity];
			entryArray[key.hashCode()%capacity] = null;
			return temp.getValue();
		}
		}
		} catch(NullPointerException e) {
			 return null;
		} catch (ClassCastException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		}
		return null;
	}
	/**
	 * Simple getter for size
	 * @return size
	 */
	@Override
	public int size() {
		return size;
	}
	/**
	 * gets the list of values from the array
	 * iterates through the array and adds each elements value to a ArrayList
	 * @return test
	 */
	@Override
	public Collection<V> values() {
		ArrayList<V> test = new ArrayList<V>();
		for (int i = 0; i < capacity; i ++)
		{
			if (entryArray[i] != null)
				test.add(entryArray[i].getValue());
		}
		return test;
	}
	/**
	 * Getter for the array
	 * @return entryArray
	 */
	@Override
	public HashTableEntry<K, V>[] getArray() {
		return entryArray;
	}
	/**
	 * Setter for the array
	 */
	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		this.entryArray = array;
	}
	/**
	 * Setter for the capacity
	 */
	@Override
	public void setSize(int size) {
		this.capacity = size;
	}

}