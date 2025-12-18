class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long orgProfit = 0;
        int n = prices.length;
        for(int i=0;i<n;i++){
            orgProfit += (long)prices[i]*strategy[i];
        }

        long wfProfit = 0;
        int half = k/2;
        
        for(int i=0;i<k;i++){
            wfProfit += (long) prices[i]*strategy[i];
        }

        long prefix[] = new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i]+prices[i]; 
        }

        long wsProfit = prefix[k] - prefix[k-half];
        long maxGain = wsProfit - wfProfit;
        
        for(int i=1;i<=n-k;i++){
            wfProfit -= (long) strategy[i-1]*prices[i-1];
            wfProfit += (long) strategy[i+k-1]*prices[i+k-1];

            wsProfit = prefix[i+k] - prefix[i+k-half];
            
            maxGain = Math.max(maxGain, wsProfit - wfProfit);
        }
        return orgProfit + Math.max(0,maxGain);
    }
}