class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int reqTime = 0;
        char prev = colors.charAt(0);
        int prevTime = neededTime[0];
        for(int i=1;i<n;i++){
            if(prev == colors.charAt(i)){
                reqTime += Math.min(prevTime, neededTime[i]);
                prevTime = Math.max(prevTime, neededTime[i]);;
            }
            else{
                prevTime = neededTime[i];
                prev = colors.charAt(i);
            }
        }
        return reqTime;
    }
}