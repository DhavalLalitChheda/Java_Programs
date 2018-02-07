class StrStr{
	public static void main(String args[]){
		String needle = args[1];
		String haystack = args[0];
		StrStr s = new StrStr();
		int index = s.strStr(haystack, needle);
		System.out.println("The index of first occurence of needle in the stack is: " + index);
	}
	private int strStr(String haystack, String needle){
		return haystack.indexOf(needle);
	}
}