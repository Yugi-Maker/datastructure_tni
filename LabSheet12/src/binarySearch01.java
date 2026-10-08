import java.util.Scanner;

public class binarySearch01 {

	public static void main(String[] args) {
		int[] nums = sorting(new int[]{96, 87, 18, 6, 31, 11, 56, 36, 76});
		
		for (int num : nums) {
			System.out.println(num + " ");
		}

				Scanner input = new Scanner(System.in);
		System.out.println("Input a target number: ");
		int target = input.nextInt();
		
		int index = binarySearch(nums, target);
		
		if (index != -1) {
			System.out.println("\nThe target " + target + " at index " + index);
		} else {
			System.err.println("\nCannot found " + target + " in this array");
		}

	}
	
	public static int[] sorting(int[] nums) {
		Sorting sort = new Sorting(nums);
		sort.bubbleSort();
		return sort.getArray();
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
