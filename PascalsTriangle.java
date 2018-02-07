import java.util.*;
class PascalsTriangle{
	public static void main(String args[]){
		int numberOfRows = Integer.parseInt(args[0]);
		PascalsTriangle p = new PascalsTriangle();
		List<List<Integer>> rows = p.getPascalsTriangle(numberOfRows);
		int i = 0;
		for(List<Integer> temp: rows){
			int j = 0;
			for(Integer x: temp){
				System.out.print(x + ", ");
				j++;
			}
			System.out.println();
			i++;
		}
	}
	private List<List<Integer>> getPascalsTriangle(int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n <= 0){
			return res;
		}
		for(int i = 0; i < n; i++){
			List<Integer> eachRow = new ArrayList<Integer>();
			
			for(int j = 0; j < i+1; j++){
				if(j == 0 || j == i){
					eachRow.add(1);
				} else{
					eachRow.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
				}
			}
			res.add(eachRow);
		}
		return res;
	}
}