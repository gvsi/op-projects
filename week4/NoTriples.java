public class NoTriples {

	public static boolean noTriples(int[] nums) {
		boolean noTriples = true;
		
		if (nums.length >= 3) {
			int n = nums[0];
			int count = 1;
			for (int i = 1; i < nums.length; i++) {
				if (n == nums[i]) {
					count++;
					if (count == 3) {
						noTriples = false;
						break;
					}
				} else {
					n = nums[i];
					count = 1;
				}
				
			}
		}
		
		return noTriples;
		
	}
	
}
