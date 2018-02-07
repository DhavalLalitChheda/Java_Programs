class SearchInsert{
	public static void main(String args[]){
		int target = Integer.parseInt(args[0]);
		int[] input = new int[args.length - 1];
		for(int i = 1; i < args.length; i++){
			input[i-1] = Integer.parseInt(args[i]);
		}
		SearchInsert si = new SearchInsert();
		int position = si.searchPosition(input, target);
		System.out.println("The position where the element is/should be inserted: " + position);
	}
	private int searchPosition(int[] input, int target){
		int pos = 0, high = input.length - 1, low = 0;
		while (low <= high){
			int mid = (low + high)/2;
			if(input[mid] == target){
				return mid;
			} else if(input[mid] > target){
				high = mid -1;
			} else{
				low = mid + 1;
			}
		}
		return low;
	}
}