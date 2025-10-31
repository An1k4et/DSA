class Solution {
    private boolean isBalanced(int n){
        int freq[] = new int[10];
        while(n > 0){
            int lastDigit = n%10;
            if(lastDigit == 0) return false;
            freq[lastDigit]++;
            n /= 10;
        }
        for(int i=1;i<=9;i++){
            if(freq[i] != 0 && (freq[i] != i)){
                return false;
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int maxVal = 1224444;
        for(int i=n+1;i<=maxVal;i++){
            if(isBalanced(i)){
                return i;
            }
        }
        return 0;
    }
}