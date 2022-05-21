public class MissionThree {

	/**
	 * Merges two sorted arrays, and computer the difference in scores
	 * 
	 * @param person1 a sorted array of medals
	 * @param person2 a sorted array of medals
	 * @return the difference in score of person1 and person2
	 */
	public static <T extends Comparable<? super T>> int merge(T[] person1, T[] person2) {
		MissionTwo <T> mergedArray = new MissionTwo <T>(person1.length+person2.length);
		for (int i = 0; i < person1.length; i++)
			mergedArray.add(person1[i]);
		for (int i = 0; i < person2.length; i++)
			mergedArray.add(person2[i]);
		int personOnepoints = 0;
		int personTwopoints = 0;
		mergedArray.remove();
		for (int i = 0; i < (person1.length+person2.length); i++) {
			for(int j = 0; j < person1.length; j++)
				if (mergedArray.getData(i) == person1[j])
					personOnepoints += i+1;
			for(int h = 0; h < person2.length; h++)
				if (mergedArray.getData(i) == person2[h])
					personTwopoints += i+1;
			
		}
		return personOnepoints - personTwopoints;
	}
	
}