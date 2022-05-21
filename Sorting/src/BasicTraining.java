public class BasicTraining {

	/**
	 * Sort the array using quick sort, this must be:
	 * 
	 * in-place (no temporary arrays)
	 * O(n log n)
	 * 
	 * @param array
	 * @return a sorted array
	 */
	public static <T extends Comparable<? super T>> T[] quickSort(T[] array) {
		T temporaryValue;
		for(int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					temporaryValue = array[i];
					array[i] = array[j];
					array[j] = temporaryValue;
					
				}
			}
		}
		return null;
	}
	
}