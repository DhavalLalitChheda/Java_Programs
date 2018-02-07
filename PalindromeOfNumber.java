class PalindromeOfNumber{
	public static void main(String args[]){
	String result = " is not a palindrome";
		if(isPalindrome(Integer.parseInt(args[0]))){
			result = " is a palindrome";
		}
		System.out.println("The number " + args[0] + result);
	}
	public static boolean isPalindrome(int x){
		int reverse = 0, original = x;

		if(x < 0 || (x % 10 == 0 && x != 0)){
			return false;
		} else{
			while(x > 0){
				reverse = reverse * 10 + x % 10;
				x = x/10;
			}
		}
		if(original == reverse){
			return true;
		} else{
			return false;
		}
	}
}