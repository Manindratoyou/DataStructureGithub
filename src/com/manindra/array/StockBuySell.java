package com.manindra.array;

public class StockBuySell {

    public static void main(String[] args) {
        int [] arr={1,5,3,8,12};
        //System.out.println(maxProfitSolOne(arr,0, arr.length-1));
        System.out.println(maxProfitSolTwo(arr));
    }
    static int maxProfitSolOne(int [] price,int start,int end){
        if (end<=start)
            return 0;
        int profit=0;
        for (int i=start;i<end;i++){
            for (int j=i+1;j<=end;j++){
                if (price[j]>price[i]){
                    int curr_profit = price[j] - price[i]
                            + maxProfitSolOne(price, start, i - 1)
                            + maxProfitSolOne(price, j + 1, end);
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

    static int maxProfitSolTwo(int [] price){
        int profit=0;
        for (int i=1;i<price.length;i++){
            if (price[i]>price[i-1])
                profit+=price[i]-price[i-1];
        }
        return profit;
    }
}
