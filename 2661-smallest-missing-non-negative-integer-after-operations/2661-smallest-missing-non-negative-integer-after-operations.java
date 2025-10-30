class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int temp = ((num % value) + value) % value;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int MEX = 0;
        while(map.getOrDefault(MEX % value, 0) > 0){
            map.put(MEX % value, map.getOrDefault(MEX % value, 0) - 1);
            MEX++;
        }
        return MEX;
    }
}