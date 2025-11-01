class Solution {
    public int totalMoney(int n) {
        int fullWeeks = n/7;
        int remWeeks = n%7;
        int sumWeeks = 28*fullWeeks + 7*(fullWeeks - 1) * fullWeeks /2;
        int sumRem = remWeeks * (remWeeks + 1) / 2 + remWeeks * fullWeeks;

        return sumWeeks + sumRem;
    }
}