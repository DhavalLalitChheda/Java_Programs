class ValidPalindrome{
	public static void main(String args[]){
		ValidPalindrome v = new ValidPalindrome();
		if(v.isValidPalindrome(args[0])){
			System.out.println("The given string is a valid palindrome.");
		} else{
			System.out.println("The given string is not a valid palindrome.");
		}
	}
	private boolean isValidPalindrome(String args){
		if(args.isEmpty()){
			return true;
		}
		int i = 0, j = args.length() - 1;
		while(i < j){
			char c = args.charAt(i);
			char d = args.charAt(j);
			if(!Character.isLetterOrDigit(c)){
				i++;
			} else if(!Character.isLetterOrDigit(d)){
				j--;
			} else{
				if(Character.toLowerCase(c) != Character.toLowerCase(d)){
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}
}