import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class jumpSearch02 {

	public static void main(String[] args) {
		LinkedList<Integer> list = random_initial();

		list.sort((a, b) -> {
			return a.compareTo(b);
		});
		System.out.print("Element after sorting : ");

		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();

		int[] nums = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter target: ");
		int target = sc.nextInt();
		int result = jumpSearch(nums, target);

		if (result != -1) {
			System.out.println(
				"The target (" + target + ") at index " + result
			);
		} else {
			System.err.println(
				"Cannot found " + target + " in this linked list"
			);
		}
		
		sc.close();
	}
	
	public static LinkedList<Integer> random_initial() {
		LinkedList<Integer> nums = new LinkedList<Integer>();

		Random rnd = new Random();

		while (nums.size() < 10) {
			nums.add(rnd.nextInt(99));
		}

		return nums;
	}
	
	public static int jumpSearch(int[] nums, int target) {
        int jump_size = (int) Math.floor(Math.sqrt(nums.length));
		
		
		int start = 0;
		int m = 0;
		
		while (m < nums.length) {
			if (target == nums[m])
				return m;
			else if (target > nums[m]) {
				start = m;
				m += jump_size;
			} else {
				for (int i=start; i<m; i++) {
					if (target == nums[i])
						return i;
				}
				return -1;
			}
		}
		for (int i=start; i<nums.length; i++) {
			if (target == nums[i])
				return i;
		}
		
		return-1;
	}

}
