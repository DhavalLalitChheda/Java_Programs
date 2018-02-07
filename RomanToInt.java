import java.util.*;

class RomanToInt{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a valid roman number: ");
		String word = sc.nextLine();
		System.out.println("The converted string is: " + convertToInt(word));
	}
	private static int convertToInt(String word){
		int sum = 0, prev = 0, next = 0;
		if(word.trim().length() == 0){
			return 0;
		}	
		Map<Character, Integer> map = new HashMap();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		prev = map.get(word.charAt(0));
		int i = 1;
		
		while(i < word.length()){
			next = map.get(word.charAt(i));
			if(prev < next){
				sum -= prev;
			} else{
				sum += prev;
			}
			prev = next;
			i++;
		}	
		sum += prev;
		
		return sum;
	}	
}