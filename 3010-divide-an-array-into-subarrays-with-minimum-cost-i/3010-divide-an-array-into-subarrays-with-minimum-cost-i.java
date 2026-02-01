class Solution {
    public int minimumCost(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int secMin = 0;
        for(int i=1;i<nums.length;i++){
            if(minVal > nums[i]){
                secMin = minVal;
                minVal = nums[i];
            }
            else if(secMin > nums[i]){
                secMin = nums[i];
            }
        }
        return nums[0] + minVal + secMin;
    }
}