
public class test {

	public static void main(String[] args) {
		String[] data3 = new String[] {"a", "lo", "penis"};
		String[] data4 = new String[] {"testies", "boob", "ass"};
		Integer[] data = new Integer[] {6, 8, 3, 0, 11, 34, 5, 89, 35};
		Integer[] data2 = new Integer[] {1, 2, 4, 5, 7, 9, 10, 12, 13};
		MissionTwo<Integer> test = new MissionTwo<Integer>(5);
		test.add(11);
		test.add(1);
		test.add(39);
		test.add(5);
		test.add(16);
		MissionTwo<String> test2 = new MissionTwo<String>(5);
		test2.add("11");
		test2.add("1");
		test2.add("ass");
		test2.add("tits");
		test2.add("boobs");

		System.out.println(MissionThree.merge(data, data2));
		System.out.println(MissionThree.merge(data3, data4));
}
}
