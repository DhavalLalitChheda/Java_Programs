class CountOccurenceSubstring{
	public static void main(String args[]){
	CountOccurenceSubstring c = new CountOccurenceSubstring();
		int count = c.getCount(args[0], args[1]);
		System.out.println("Count is: " + count);
	}
	public int getCount(String a, String b){
		int count = 0;
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < b.length()) {
	        sb.append(a);
	        count++;
	    }
	    if(sb.toString().contains(b)){
	    	return count;	
	    } 
	    if(sb.append(a).toString().contains(b)){
	    	return ++count;
	    } 
		return -1;
	}
}