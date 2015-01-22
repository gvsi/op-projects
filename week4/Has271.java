public class Has271 {
	public static boolean has271(int[] nums) {
		boolean has271 = false;
		
		if (nums.length >= 3) {
			for (int i = 0; i < nums.length - 2; i++) {
				if (nums[i+1] == nums[i] + 5 && nums[i+2] == nums[i] - 1) {
					has271 = true;
					break;
				}
			}
		}
		
		return has271;
	}
}
