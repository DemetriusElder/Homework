import java.util.Map.Entry;
/** This is HashTable Homework. 5/20/2022
 * This program is to act as the HashTableEntry class.
 * This class is filled with functions and constructors that serve to create
 * and modify the items that will be entered into the Hashtable.
 * @author dewwy(Demetrius Elder)
 * Sorry thats my name in github dont know how to change it yet
 * @version 1
 */
public class HashTableEntry<K,V> implements Entry<K, V> {

	/**
	 * The set of variables needed to navigate creating a object Hashtableentry
	 * Key is one value assigned to the element
	 * Value is the second value assigned to the element
	 * Available is just to check if I can replace the element
	 */
	private K key;
	private V value;
	private boolean avail = false;
	/**
	 * creates the HashTableEntry object by initializing the key and value elements
	 * @param key , value
	 */
	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	/**
	 * Simple getter for the avail status
	 * @return avail
	 */
	public boolean isAvailable(){
		return avail;
	}
	/**
	 * Simple setter for the avail status
	 * @param isAvailable
	 */
	public void setAvailable(boolean isAvailable){
		this.avail = isAvailable;	
	}
	/**
	 * Simple getter for the key status
	 * @return key
	 */
	@Override
	public K getKey() {
		return key;
	}
	/**
	 * Simple getter for the value status
	 * @return value
	 */
	@Override
	public V getValue() {
		return value;
	}
	/**
	 * Setter for value with the added function of returning the old value
	 * @param value
	 * @return temp
	 */
	@Override
	public V setValue(V value) {
		V temp = this.value;
		this.value = value;
		return temp;
	}
	/**
	 * Personal hashcode code for this assignment
	 * Checks that key and value are not not null.
	 * if it is null it returns 0
	 * if it is not it runs it through the hashcode functions
	 * then converts to int
	 * @returns hashcode int
	 */
	
	@Override
	public int hashCode(){
		return (int)    (key==null   ? 0 : key.hashCode()) ^  (value==null ? 0 : value.hashCode());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Personal equal checker for this code
	 * Checks if the key or value is null
	 * if they are it simply checks if the object o is also null
	 * if they are not null then it calls the equals to check the two vlues of Object o and the initial object if they are equal
	 * if both values come out to true then return true else return false
	 * @param Object o
	 * @returns hashcode int
	 */
	public boolean equals(Object o){
		return (key==null ? ((Entry<K, V>) o).getKey()==null : key.equals(((Entry<K, V>) o).getKey()))  &&
			   (value==null ? ((Entry<K, V>) o).getValue()==null : getValue().equals(((Entry<K, V>) o).getValue()));
	}
}