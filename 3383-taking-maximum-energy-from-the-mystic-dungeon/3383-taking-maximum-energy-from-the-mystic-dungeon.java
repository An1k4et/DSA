class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int dp[] = new int[n+1];

        int maxEnergy = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(i+k < n) dp[i] = dp[i+k] + energy[i];
            else dp[i] = energy[i];
        }

        for(int i=0;i<n;i++){
            maxEnergy = Math.max(maxEnergy, dp[i]);
        }

        return maxEnergy;
    }
}