class Solution {
    int t[][][];
    private int solve(int count[][], int m, int n, int i){
        if(i >= count.length){
            return 0;
        }
        if(t[m][n][i] != -1){
            return t[m][n][i];
        }
        int take = 0;
        if(count[i][0] <= m && count[i][1] <= n){
            take = 1 + solve(count, m-count[i][0], n-count[i][1], i+1);
        }
        int skip = solve(count, m, n, i+1);
        return t[m][n][i] = Math.max(take, skip);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        t = new int[101][101][601];
        for(int dp[][]:t){
            for(int d[] : dp){
                Arrays.fill(d, -1);
            }
        }

        int count[][] = new int[len][2];
        for(int i=0;i<len;i++){
            for(char ch : strs[i].toCharArray()){
                count[i][ch-'0']++;
            }
        }

        return solve(count, m, n, 0);
    }
}