class PlusOne{
	public static void main(String args[]){
		int[] input = new int[args.length];
		for(int i = 0; i < args.length; i++){
			input[i] = Integer.parseInt(args[i]);
		}
		PlusOne po = new PlusOne();
		int[] result = po.getPlusOne(input);
		System.out.println();
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i]);
		}
	}
	public int[] getPlusOne(int[] digits) {
	    for (int i = digits.length - 1; i >=0; i--) {
	        if (digits[i] != 9) {
	            digits[i]++;
	            break;
	        } else {
	            digits[i] = 0;
	        }
	    }
	    if (digits[0] == 0) {
	        int[] res = new int[digits.length+1];
	        res[0] = 1;
	        return res;
	    }
	    return digits;
	}

}