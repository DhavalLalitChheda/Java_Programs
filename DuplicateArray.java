class DuplicateArray{
	public static void main(String args[]){
		int[] y = new int[args.length];
		for(int i = 0; i < args.length; i++){
			y[i] = Integer.parseInt(args[i]);
		}
		System.out.println("The new array contains " + removeDuplicates(y) + "elements");
	}
	public static int removeDuplicates(int[] x){
		int i = 0;
		if(x != null && x.length > 0){
			
			for(int j = 1; j < x.length; j++){
				if(x[i] != x[j]){
					i++;
					x[i] = x[j];
				}
			}
			i = i + 1;
		}
		return i;
	}
}