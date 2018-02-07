class AddBinary{
	private String addBinary(String a, String b){
		int aLength = a.length();
		int bLength = b.length();

		int i = 0, carry = 0;
		String res = "";
		while(i < aLength || i < bLength || carry != 0){
			System.out.println();
			int x=(i<aLength)?((a.charAt(aLength-1-i)=='1')?1:0):0;
        	int y=(i<bLength)?((b.charAt(bLength-1-i)=='1')?1:0):0;
			res=(x+y+carry)%2+res;
        	carry=(x+y+carry)/2;

			i++;
		}
		return res;
	}
	public static void main(String args[]){
		AddBinary a = new AddBinary();
		System.out.println("The output is: " + a.addBinary(args[0], args[1]));
	}
}