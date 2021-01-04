package logic;

public class StockBuySellToMaximizeProfit {
	private static int maximizeProfit(int arrStockPrice[]) {
		if (arrStockPrice == null || arrStockPrice.length < 2) {
			return 0;
		}
		int lowestStockPriceTillNow = arrStockPrice[0];
		int maxProfitTillNow = 0;
		for (int i = 0; i < arrStockPrice.length; i++) {
			if (arrStockPrice[i] < lowestStockPriceTillNow) {
				lowestStockPriceTillNow = arrStockPrice[i];
			} else {
				if (arrStockPrice[i] - lowestStockPriceTillNow > maxProfitTillNow) {
					maxProfitTillNow = arrStockPrice[i] - lowestStockPriceTillNow;
				}
			}
		}
		return maxProfitTillNow;
	}

	public static void main(String[] args) {
		int profit = maximizeProfit(new int[] { 100, 80, 120, 130, 70, 60, 100, 125 });
		System.out.println(profit);
	}
}
