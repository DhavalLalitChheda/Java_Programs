import java.util.*;

class ZigZagConversion{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a word to be converted to zigzag: ");
		String word = sc.next();
		System.out.println("Please number of rows: ");
		int rows = Integer.parseInt(sc.next());
		System.out.println(convertToZigZag(word, rows));
	}
	private static String convertToZigZag(String word, int rows){
		char[] c = word.toCharArray();
		int len = c.length;
		StringBuffer[] s = new StringBuffer[rows];
		for(int i = 0; i < s.length; i++){
			s[i] = new StringBuffer();
		}
		
		int j = 0;
		while(j < len){
			for(int index = 0; index < s.length && j < len; index++){
				s[index].append(c[j++]);
			}
			for(int index = rows - 2; index >= 1 && j < len; index--){
				s[index].append(c[j++]);
			}
		}
		for(int index = 1; index < s.length; index++){
			s[0].append(s[index]);
		}
		return s[0].toString();
	}	
}