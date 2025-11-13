class Solution {
    public int minOperations(int[] nums) {
        int countOne = 0;
        int n = nums.length;
        for(int num:nums){
            if(num == 1) countOne++;
        }
        if(countOne > 0){
            return n - countOne;
        }
        int minOperation = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int gcdNum = nums[i];
            for(int j=i+1;j<n;j++){
                gcdNum = gcd(gcdNum, nums[j]);
                if(gcdNum == 1){
                    minOperation = Math.min(minOperation, j-i);
                }
            }
        }
        if(minOperation == Integer.MAX_VALUE){
            return -1;
        }
        return n - 1 + minOperation ;
    }
    private int gcd(int a, int b){
        while(b !=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}