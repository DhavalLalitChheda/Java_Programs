class LongestCommonPrefix{
	public static void main(String args[]){
		System.out.println("The longest common prefix is: " + commonPrefix(args));
	}
	public static String commonPrefix(String[] input){
		if(input != null && input.length > 1){
			for(int i = 0; i < input[0].length(); i++){
				char c = input[0].charAt(i);
				for(int j = 1; j < input.length; j++){
					if(i == input[j].length() || input[j].charAt(i) != c){
						return input[0].substring(0, i);
					}
				}
			}
		}
		return result;
	}
}