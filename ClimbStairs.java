class ClimbStairs{
	private int waysToClimbStairs(int n){
		if(n == 0)
			return 0;
		else if(n == 1){
			return 1;
		} else{
			int[] result = new int[n + 1];
			result[0] = 1;
			result[1] = 1;
			for(int i = 2; i <= n; i++){
				result[i] = result[i-1] + result[i-2];
			}
			return result[n];
		}
		
	}
	public static void main(String args[]){
		ClimbStairs c = new ClimbStairs();
		System.out.println("The number of ways are: " + c.waysToClimbStairs(Integer.parseInt(args[0])));
	}
}