public class ArrayFront9 {
    public static boolean arrayFront9(int[] nums) {
       boolean hasNine = false;
       for (int i = 0; (i < 4 && nums.length >= 4) || (i < nums.length && nums.length < 4); i++) {
    	   if (nums[i] == 9) {
    		   hasNine = true;
    		   break;
    	   }
       }
       return hasNine;
    }

    public static void main(String[] args) {
        int N = args.length;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println(arrayFront9(nums));
    }
}