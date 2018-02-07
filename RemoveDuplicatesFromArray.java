import java.util.*;
class RemoveDuplicatesFromArray{
	public static void main(String args[]){
		int val = Integer.parseInt(args[0]);
		int[] input = new int[args.length - 1];
		for(int i = 0; i < args.length - 1; i++){
			input[i] = Integer.parseInt(args[i + 1]);
		}
		RemoveDuplicatesFromArray dup = new RemoveDuplicatesFromArray();
		int length = dup.removeDuplicates(input, val);
		System.out.println("The new length of an array: " + length);
	}
	private int removeDuplicates(int[] input, int val){
		int i = 0;
		if(input != null && input.length > 0){
			for(int j = 0; j < input.length; j++){
				if(input[j] != val){
					input[i] = input[j];
					i++;
				}
			}
		}
		return i;
	}
}