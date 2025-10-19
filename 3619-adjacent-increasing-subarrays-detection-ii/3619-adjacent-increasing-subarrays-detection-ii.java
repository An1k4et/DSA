class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prevRun = 0;
        int currRun = 1;

        int n = nums.size();
        int maxLen = 0;
        for(int i=1;i<n;i++){
            if(nums.get(i-1) < nums.get(i)){
                currRun++;
            }
            else{
                prevRun = currRun;
                currRun = 1;
            }
            maxLen = Math.max(maxLen, currRun/2);
            maxLen = Math.max(maxLen, Math.min(prevRun, currRun));
        }
        return maxLen;
    }
}