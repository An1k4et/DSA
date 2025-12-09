class Solution {
    final int MOD = 1_000_000_007;
    
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long count = 0;
        
        Map<Integer, Integer> rFreq = new HashMap<>();
        Map<Integer, Integer> lFreq = new HashMap<>();
        for(int num:nums){
            rFreq.put(num, rFreq.getOrDefault(num, 0)+1);
        }
        for(int i=0;i<n;i++){
            int center = nums[i];

            rFreq.put(center, rFreq.get(center)-1);
            
            int left = lFreq.getOrDefault(center*2, 0);
            int right = rFreq.getOrDefault(center*2, 0);
            count = (count + (1L * left * right))%MOD;

            lFreq.put(center, lFreq.getOrDefault(center, 0)+1);
        }

        return (int)count;
    }
}