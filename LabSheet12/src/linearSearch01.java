import java.util.Scanner;

public class linearSearch01 {

	public static void main(String[] args) {
		int[] nums = {96, 87, 18, 6, 31, 11, 56, 36, 76};
		
		for (int num : nums) {
			System.out.println(num + " ");
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Input a target number: ");
		int target = input.nextInt();
		
		int index = linearSeach(nums, target);
		
		if (index != -1) {
			System.out.println("\nThe target " + target + " at index " + index);
		} else {
			System.err.println("\nCannot found " + target + " in this array");
		}

	}
	
	public static int linearSeach(int[] nums, int target) {
		for (int i=0; i<nums.length; i++) {
			if (target == nums[i])
				return i;
		}
		return -1;
	}

}
