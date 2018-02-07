import java.util.*;

class ThreeSumClosest{
	public static void main(String args[]){
		int x[] = {-1, 0, 1, 2, -1, -4};
		int target = 4;
		System.out.println(findClosestThreeSum(x, target));
	}
	private static int findClosestThreeSum(int[] x, int target){
		Arrays.sort(x);
		int result = x[0] + x[1] + x[2];
		for(int i = 0; i < x.length; i++){
			for(int j = i +1, k = x.length - 1; j < k; ){
				int sum = x[i] + x[j] + x[k];
				if(Math.abs(target - result) >= Math.abs(target - sum)){
					result = sum;
				}
				if(result == target){
					return result;
				}
				if(sum > target)
					k--;
				else
					j++;
			}	
		}	
		
		return result;
	}
}