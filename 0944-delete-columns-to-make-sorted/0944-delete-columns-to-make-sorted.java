class Solution {
    public int minDeletionSize(String[] strs) {
        
        if(strs.length == 1){
            return 0;
        }

        int count = 0;
        int n = strs[0].length();
        for(int i=0;i<n;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j-1].charAt(i) > strs[j].charAt(i)){
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}