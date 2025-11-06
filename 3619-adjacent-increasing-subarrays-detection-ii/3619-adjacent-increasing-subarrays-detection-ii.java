class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prev = Integer.MIN_VALUE;
        int curr = 1;
        int maxPossible = 0;
        int n = nums.size();
        for(int i=1;i<n;i++){
            if(nums.get(i-1) < nums.get(i)){
                curr++;
            }
            else{
                prev = curr;
                curr = 1;
            }
            maxPossible = Math.max(maxPossible, curr/2);
            maxPossible = Math.max(maxPossible, Math.min(prev, curr));
        }
        return maxPossible;
    }
}