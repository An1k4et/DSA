class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxLen = Arrays.stream(nums).max().getAsInt() + k;

        int cumFreq[] = new int[maxLen + 1];
        for(int num : nums){
            cumFreq[num]++;
        }

        for(int i=1;i<=maxLen;i++){
            cumFreq[i] += cumFreq[i-1];
        }

        int maxFreq = 0;
        for(int target=0; target<=maxLen; target++){
            int left = Math.max(0, target - k);
            int right = Math.min(maxLen, target + k);

            int totalCount = cumFreq[right] - ((left - 1) > 0 ? cumFreq[left - 1] : 0);
            int targetCount = cumFreq[target] - ((target - 1) > 0 ? cumFreq[target - 1] : 0);

            int needConversion = totalCount - targetCount;
            int maxObtain = targetCount + Math.min(needConversion, numOperations);

            maxFreq = Math.max(maxFreq, maxObtain);
        }
        return maxFreq;
    }
}