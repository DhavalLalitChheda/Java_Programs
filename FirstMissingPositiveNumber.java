import java.util.*;

class FirstMissingPositiveNumber{
	public static void main(String args[]){
		int x[] = {1,3,6,7};
		System.out.println(findFirstPositiveNumber(x));
		
	}
	private static int findFirstPositiveNumber(int[] x){
		if(x == null || x.length == 0){
			return 1;
		}
		for(int i = 0; i < x.length; i++){
			if(x[i] < 0)
				x[i] == Integer.MAX_VALUE;
		}
		for(int i = 0; i < x.length; i++){
			int n = x[i];
			if(n <= x.length){
				x[i - 1] = - Maths.abs(x[i - 1]);
			}	
		}
		for(int i = 0; i < )
	}
}