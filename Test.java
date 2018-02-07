import java.util.*;
class Test{
	public static void main(String args[]){
		int ar[] = new int[args.length - 1];
		int target = Integer.parseInt(args[args.length - 1]);
		for(int i = 0; i < args.length - 1; i++){
			ar[i] = Integer.parseInt(args[i]);
		}
		for (int j = 0; j < ar.length; j++){
			System.out.println(ar[j]);
		}
		int[] result = twoSum(ar, target);
		for (int j = 0; j < result.length; j++){
			System.out.println(result[j]);
		}
	}
	public static int[] twoSum(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
	}
}