import java.util.*;
class LengthOfLastWord{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a line");
		String line = sc.nextLine();
		LengthOfLastWord l = new LengthOfLastWord();
		System.out.println("The length of the last word is: " + l.getLengthOfLastWord(line));
	}
	private int getLengthOfLastWord(String line){
		int length = 0;
		if(line == null || line.trim().length() == 0){
			return length;
		} else {
			String[] words = line.split(" ");
			return words[words.length - 1].length();
		}
	}
}