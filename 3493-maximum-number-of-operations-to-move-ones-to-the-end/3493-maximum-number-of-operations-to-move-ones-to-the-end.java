class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int countOne = 0;
        int i=0;
        int ops = 0;
        while(i<n){
            if(s.charAt(i) == '0'){
                ops += countOne;
                while(i<n && s.charAt(i) == '0'){
                    i++;
                }
            }
            else{
                countOne++;
                i++;
            }
        }
        return ops;
    }
}