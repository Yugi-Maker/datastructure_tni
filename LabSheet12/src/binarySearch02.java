import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class binarySearch02 {

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
		int result = binarySearch(nums, target);
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
	
	public static int binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length-1;
		
		while (low <= high) {
			int middle = (low+high)/2;
			
			if (target == nums[middle]) {
				return middle;
			}
			if (target < nums[middle]) {
				high = middle -1;
			} else {
				low = middle + 1;
			}
		}
		
		return -1;
	}

}
