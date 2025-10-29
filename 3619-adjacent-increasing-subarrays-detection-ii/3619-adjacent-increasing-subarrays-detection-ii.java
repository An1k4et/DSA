class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int maxPossible = 0;
        int prev = 0;
        int curr = 1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1) < nums.get(i)){
                curr++;
            }
            else{
                prev = curr;
                curr = 1;
            }
            maxPossible = Math.max(maxPossible, Math.abs(curr/2));
            maxPossible = Math.max(maxPossible, Math.min(curr, prev));
        }
        return maxPossible;
    }
}