class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int prev = Integer.MIN_VALUE;
        int count = 0;

        Arrays.sort(nums);
        for(int num:nums){
            int minVal = num - k;
            if(prev < minVal){
                prev = minVal;
                count++;
            }
            else if(prev < num + k){
                prev = prev + 1;
                count++;
            }
        }
        return count;
    }
}