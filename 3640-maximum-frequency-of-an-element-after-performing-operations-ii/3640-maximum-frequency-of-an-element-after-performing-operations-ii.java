class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        Map<Integer, Integer> diff = new TreeMap<>();
        Map<Integer, Integer> freq = new TreeMap<>(); 

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);

            int left = Math.max(0, num - k);
            int right = Math.min(maxVal, num + k);

            diff.put(left, diff.getOrDefault(left, 0)+1);
            diff.put(right+1, diff.getOrDefault(right+1, 0)-1);

            diff.putIfAbsent(num, diff.getOrDefault(num, 0));
        }

        int result = 1;
        int cumSum = 0;

        for(Map.Entry<Integer, Integer> entry : diff.entrySet()){
            int target = entry.getKey();
            int val = entry.getValue();

            cumSum += val;

            int targetCount = freq.getOrDefault(target, 0);
            int needConversion = cumSum - targetCount;

            int maxObtain =  targetCount + Math.min(numOperations, needConversion);
            result = Math.max(result, maxObtain);
        }
        return result;
    }
}