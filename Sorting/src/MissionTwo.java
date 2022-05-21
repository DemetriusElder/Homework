
public class MissionTwo<T extends Comparable<? super T>> {

	private T[] data;
	private int size = 0;
	
	/**
	 * Default Constructor
	 */
	@SuppressWarnings("unchecked")
	public MissionTwo(int maxCapacity) {
		this.data = (T[]) new Comparable[maxCapacity];
		return;
	}
	
	/**
	 * Adds the item to the structure, must be
	 * 
	 * in-place
	 * stable
	 * O(n)
	 * 
	 * @param item
	 */
	public void add(T item) {
		data[size] = item;
		size++;
	}
	
	/**
	 * This must return the smallest element in this structure, must be
	 * 
	 * in-place
	 * stable
	 * O(1)
	 * 
	 * @return the smallest element currently in this structure
	 */
	public T remove() {
		BasicTraining.quickSort(data);
		return data[0];
	}
	public T getData(int index) {
		return data[index];
	}
	
}