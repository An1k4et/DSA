class Solution {
    public int findSmallestInteger(int[] nums, int values) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            int temp = ((num % values) + values) % values;
            map.put(temp , map.getOrDefault(temp, 0) + 1);
        }
        int MEX = 0;

        while(map.getOrDefault(MEX % values, 0) > 0){
            map.put(MEX % values , map.get(MEX % values) - 1);
            MEX++;
        }

        return MEX;
    }
}