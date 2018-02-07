import java.util.*;
class IndexPascalsTriangle{
	public static void main(String args[]){
		IndexPascalsTriangle i = new IndexPascalsTriangle();
		List<Integer> row = i.getIndexRowPascalTriangle(Integer.parseInt(args[0]));
		for(Integer x : row){
			System.out.print(x + " ");
		}
	}
	private List<Integer> getIndexRowPascalTriangle(int k){
		List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
		for(int i = 0; i < k+1; i++){
			List<Integer> eachRow = new ArrayList<Integer>();
			for(int j = 0; j < i+1; j++){
				if(j == 0 || j == i){
					eachRow.add(1);
				} else{
					eachRow.add(tempResult.get(i-1).get(j-1) + tempResult.get(i-1).get(j));
				}
			}
			tempResult.add(eachRow);
		}
		return tempResult.get(k);
	}
}