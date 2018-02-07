import java.util.*;

class StringToInt{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a word to be converted to int: ");
		String word = sc.nextLine();
		System.out.println("The converted string is: " + convertToInt(word));
	}
	private static int convertToInt(String word){
		int result = 0, index = 0, sign = 1;
		//removing spaces
		word = word.trim();
		String str = word.replace(" ", "");
		if(str.length() == 0){
			return 0;
		}
		//checking for the sign
		if(str.charAt(index) == '-'){
			sign = -1;
			index++;
		}
		while(index < str.length()){
			int digit = str.charAt(index) - '0';
			if(digit < 0 || digit > 9){
				index++;
				continue;
			} else{
				result = result * 10 + digit; 
			}	
			index++;	
		}
		return result * sign;
	}	
}