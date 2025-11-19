class Solution {
    public int findFinalValue(int[] nums, int original) {
        int dp[] = new int[1001];
        for(int num:nums){
            dp[num]++;
        }
        while(original<= 1000 && dp[original] > 0){
            original *= 2;
        }
        return original;
    }
}