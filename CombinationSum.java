import java.util.*;

class CombinationSum{
	public static void main(String args[]){
		int x[] = {1,3,6,7};
		int target = 7;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<Integer>();
		findCombination(x, result, arr, 0, target);
		for(List<Integer> temp: result){
			System.out.println(temp);
		}
	}
	private static void findCombination(int[] x, List<List<Integer>> result, List<Integer> arr, int index, int target){
		Arrays.sort(x);
		if(target < 0){
			return;
		}
		if(target == 0){
			result.add(arr);
			return;
		}
		while(index < x.length){
			List<Integer> temp = new ArrayList<Integer>(arr);
			temp.add(x[index]);
			findCombination(x, result, temp, index, target - x[index]);
			index++;
		}	
	}
}