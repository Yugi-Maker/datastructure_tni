import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class linearSearch02 {

	public static void main(String[] args) {
		LinkedList<Integer> list = random_initial();

		System.out.print("Element : ");
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

		int result = linearSearch(nums, target);

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
	
	public static int linearSearch(int[] nums, int target) {
		for (int i=0; i<nums.length; i++) {
			if (target == nums[i])
				return i;
		}
		return -1;
	}

}
