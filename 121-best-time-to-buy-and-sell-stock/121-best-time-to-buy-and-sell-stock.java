class Solution {
    public int maxProfit(int[] prices) {
         int min=prices[0];
        int mid = 0;
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]) {
                min=prices[i];
            }
            mid = prices[i]-min;
            if(mid>profit) profit=mid;
        }
        
        
        return profit;
    }
}