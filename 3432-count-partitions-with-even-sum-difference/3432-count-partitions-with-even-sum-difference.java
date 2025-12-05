class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int count = 0;
        int leftCount = 0;
        for(int i=0;i<nums.length-1;i++){
            leftCount += nums[i];
            int rightSum = sum - leftCount;
            if((rightSum - leftCount)%2==0){
                count++;
            }
        }
        return count;
    }
}