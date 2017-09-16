package pkc_1;

import java.util.ArrayList;

public class XoaPhanTuTrungLap {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();

		arr.add(1);
		arr.add(3);
		arr.add(4);
		arr.add(2);
		arr.add(6);
		arr.add(7);
		arr.add(1);
		arr.add(1);
		arr.add(8);
		arr.add(4);
		arr.add(6);
		arr.add(0);
		arr.add(1);

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			for (int j = i + 1; j < arr.size(); j++) {
				System.out.println("j 	 = " + j);
				System.out.println("size = " + arr.size());
				
				if (arr.get(i) == arr.get(j)) {
					arr.remove(j);
					j--;
				}
			}
		}
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("---------------");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
