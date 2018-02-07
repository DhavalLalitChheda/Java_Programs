class SqRt{
	private long sqRt(int x){
		long r = x;
    	while (r*r > x)
       		r = (r + x/r) / 2;
    	return r;
	}
	public static void main(String args[]){
		SqRt s = new SqRt();
		System.out.println(s.sqRt(Integer.parseInt(args[0])));
	}
}