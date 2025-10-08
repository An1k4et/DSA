class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);

        int ans[] = new int[n];
        int maxPotions = potions[m-1];
        for(int i=0;i<n;i++){
            long target = (long)Math.ceil((1.0 * success) / spells[i]) ;
            if(target > maxPotions){
                ans[i] = 0;
                continue;
            }
            int index = lowerBound(potions, (int)target);
            ans[i] = m - index;
        }

        return ans;
    }

    private int lowerBound(int potions[], int target){
        int l = 0;
        int r = potions.length;
        while(l < r){
            int mid = (l+r)/2;
            if(potions[mid] >= target) r = mid;
            else l = mid+1;
        }
        return l;
    }
}