class Solution {
    int m, n;
    int M = 1_000_000_007;
    Integer t[][][];
    private int solve(int i, int j, int currSum, int grid[][], int k){
        if(i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return ((currSum + grid[i][j]) % k == 0) ? 1 : 0;
        }

        if(t[i][j][currSum] != null){
            return t[i][j][currSum];
        }
         int newRemain = (currSum + grid[i][j]) % k;

        int down  = solve(i + 1, j, newRemain, grid, k);
        int right = solve(i, j + 1, newRemain, grid, k);

        return t[i][j][currSum] = (int)(((long)down + right) % M);
    }
    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        t = new Integer[m][n][k];

        return solve(0, 0, 0, grid, k);
    }
}