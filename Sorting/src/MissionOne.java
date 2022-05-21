public class MissionOne {

	/**
	 * Sort the array using an in-place sort, this algorithm must be:
	 * 
	 * in-place (no temporary arrays)
	 * stable
	 * O(n^2)
	 * 
	 * @param array
	 * @return array sorted
	 */
	public static <T extends Comparable<? super T>> T[] inplaceSort(T[] array) {
		T temporaryValue;
		for(int i = 0; i < array.length; i++) {
			for (int j = i +1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) == 1) {
					temporaryValue = array[i];
					array[i] = array[j];
					array[j] = temporaryValue;
				}
			}
		}
		return null;
	}
	
}