class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long finishTime[] = new long[n];
        for(int i=0;i<m;i++){
            finishTime[0] += (long)skill[0] *mana[i];
            for(int j=1;j<n;j++){
                finishTime[j] = Math.max(finishTime[j], finishTime[j-1]) + (long)skill[j]*mana[i];
            }
            for(int j=n-1;j>0;j--){
                finishTime[j-1] = finishTime[j] - (long)skill[j]*mana[i];
            }
        }

        return finishTime[n-1];
    }
}