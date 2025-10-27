class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCount = 0;
        int numLaser = 0;
        for(String s : bank){
            int currCount = 0;
            for(char ch : s.toCharArray()){
                if(ch == '1'){
                    currCount++;
                }
            }
            numLaser += (currCount * prevCount);
            if(currCount != 0){
                prevCount = currCount;
            }
        }
        return numLaser;
    }
}