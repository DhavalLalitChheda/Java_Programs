class MaximumSubArray{
	public static void main(String args[]){
		int[] input = new int[args.length];
		int i = 0;
		for(String s: args){
			input[i] = Integer.parseInt(s);
			i++;
		}
		MaximumSubArray msa = new MaximumSubArray();
		System.out.println("The maximum sub array is: " + msa.maxSubArray(input));
	}
	private int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
	}

}