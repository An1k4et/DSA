class Solution {
    private boolean isIncreasing(List<Integer> nums, int start, int end){
        for(int i=start+1;i<end;i++){
            if(nums.get(i-1) >= nums.get(i)){
                return false;
            }
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for(int i=0;i+2*k<=n;i++){
            boolean first = isIncreasing(nums, i, i+k);
            boolean second = isIncreasing(nums, i+k, i+2*k);
            if(first && second) return true;
        }
        return false;
    }
}