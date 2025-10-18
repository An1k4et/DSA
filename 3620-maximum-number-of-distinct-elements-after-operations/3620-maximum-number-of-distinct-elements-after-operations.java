class Solution {
    private int solve(int curr, int k, Set<Integer> unique){
        for(int i=-k;i<=k;i++){
            int newElement = curr + i;
            if(!unique.contains(newElement)) return newElement;
        }
        return curr;
    }
    public int maxDistinctElements(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        Arrays.sort(nums);
        for(int num:nums){
            if(!unique.contains(num)){
                unique.add(num);
            }
            else{
                int newElement = solve(num, k, unique);
                unique.add(newElement);
            }
        }
        return unique.size();
    }
}