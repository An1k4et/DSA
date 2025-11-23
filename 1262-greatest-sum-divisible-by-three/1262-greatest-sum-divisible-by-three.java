class Solution {
    private int solve(int i, int remainder, int[] nums, int[][] t) {
        if (i >= nums.length) {
            return (remainder == 0) ? 0 : Integer.MIN_VALUE;
        }

        if (t[i][remainder] != -1)
            return t[i][remainder];

        int pick = nums[i] + solve(i + 1, (remainder + nums[i]) % 3, nums, t);
        int notPick = solve(i + 1, remainder, nums, t);

        return t[i][remainder] = Math.max(pick, notPick);
    }

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] t = new int[n][3];

        for (int i = 0; i < n; i++)
            Arrays.fill(t[i], -1);

        return solve(0, 0, nums, t);
    }
}