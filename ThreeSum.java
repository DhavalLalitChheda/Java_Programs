import java.util.*;

class ThreeSum{
	public static void main(String args[]){
		int x[] = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list = findUniqueTriplets(x);
		for(List<Integer> display : list){
			System.out.println(display);
		}
	}
	private static List<List<Integer>> findUniqueTriplets(int[] x){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(x);
		
		for(int i = 0; i < x.length; i++){
			if(i > 0 && (x[i] == x[i - 1])){
				continue;
			}
			for(int j = i+1, k = x.length - 1; j < k;){
				if(x[i] + x[j] + x[k] == 0){
					result.add(Arrays.asList(x[i], x[j], x[k]));
					
					while(j < k && (x[j] == x[j + 1])){
						j++;
					}
					while(j < k && (x[k] == x[k - 1])){
						k--;
					}
					j++;
					k--;					
				} else if(x[i] + x[j] + x[k] > 0){
					k--;
				} else {
					j++;
				}
			}	
		}	
		
		return result;
	}
}