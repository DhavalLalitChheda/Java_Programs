class StockBuySell{
	public static void main(String args[]){
		int[] stockPrice = new int[args.length];
		int i = 0;
		for(String temp: args){
			stockPrice[i] = Integer.parseInt(temp);
			i++;
		}
		StockBuySell s = new StockBuySell();
		System.out.println("The max profit is: " + s.getMaxProfit(stockPrice));
	}
	private int getMaxProfit(int[] stockPrice){
		int profit = 0;
		if(stockPrice != null && stockPrice.length > 0){
			for(int i = 0; i < stockPrice.length; i++){
				for(int j = i + 1; j < stockPrice.length; j++){
					if(stockPrice[j] - stockPrice[i] > 0){
						profit = Math.max(profit, stockPrice[j] - stockPrice[i]);
					}
				}
			}
		}
		return profit;
	}
}