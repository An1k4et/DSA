class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int count = 0;
        for(int num : nums){
            int curr = num - k;
            if(prev < curr){
                prev = curr;
                count++;
            }
            else if(prev < num + k){
                prev = prev+1;
                count++;
            }
        }
        return count;
    }
}