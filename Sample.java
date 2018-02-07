class Sample{
	public static void main(String args[]){
	int count = repeatedStringMatch(args[0], args[1]);
		System.out.println("Count is: " + count);
	}
	public static int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int count = 1;
        while(sb.indexOf(b) < 0){
            if(sb.length() - a.length() > b.length()){
                return -1;
            }
            sb.append(a);
            count++;
        }
        
        return count;
	}
	

}