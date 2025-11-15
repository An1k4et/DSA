class Solution {
    public int numberOfSubstrings(String s) {
        int result = 0;
        int n = s.length();
        int countOne[] = new int[n];
        countOne[0] = (s.charAt(0) == '1' ? 1 : 0);
        for(int i=1;i<n;i++){
            countOne[i] = countOne[i-1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int oneCount = countOne[j] - (i > 0 ? countOne[i - 1] : 0);
                int zeroCount = (j - i + 1) - oneCount;

                int zSquare = zeroCount * zeroCount;
                if(zSquare > oneCount){
                    j += zSquare - oneCount - 1;
                }
                else if(zSquare == oneCount){
                    result++;
                }
                else{
                    result++;
                    int k = (int) Math.sqrt(oneCount) - zeroCount;
                    int next = j+k;
                    if(next >= n){
                        result += (n-j-1);
                        break;
                    }
                    else{
                        result += k;
                    }
                    j = next;
                }
            }
        }
        return result;
    }
}