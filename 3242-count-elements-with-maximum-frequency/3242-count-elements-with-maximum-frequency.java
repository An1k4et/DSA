class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxNums = Arrays.stream(nums).max().getAsInt();
        int freq[] = new int[maxNums + 1];

        for(int num : nums){
            freq[num]++;
        }
        int maxFreq = 0;
        int currMaxFreq = 0;
        for(int i=0;i<=maxNums;i++){
            if(currMaxFreq < freq[i]){
                 maxFreq = freq[i];
                 currMaxFreq = freq[i];
            }
            else if(currMaxFreq == freq[i]){
                maxFreq += freq[i];
            }
        }

        return maxFreq;
    }
}