class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int n = nums.length;
        int maxConsecutive = 0;
        while(i<n){
            int j = i;
            while(j<n && nums[j] == 1){
                j++;
            }
            maxConsecutive = Math.max(maxConsecutive, j-i);
            i = ++j;
        }
        return maxConsecutive;
    }
}