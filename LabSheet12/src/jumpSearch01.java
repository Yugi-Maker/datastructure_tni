import java.util.Scanner;

public class jumpSearch01 {

	public static void main(String[] args) {
        int[] nums = sorting(new int[]{96, 87, 18, 6, 31, 11, 56, 36, 76});
		
		for (int num : nums) {
			System.out.println(num + " ");
		}

				Scanner input = new Scanner(System.in);
		System.out.println("Input a target number: ");
		int target = input.nextInt();
		
		int index = jumpSearch(nums, target);
		
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
