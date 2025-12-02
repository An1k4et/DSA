class Solution {
    final int MOD = 1_000_000_007;
    final long inverseOf2 = 500000004;
    public int countTrapezoids(int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<points.length;i++){
            int x = points[i][0], y=points[i][1];
            if(!map.containsKey(y)){
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }
        long waySum = 0;
        long waySumPow2 = 0;
        for(int y : map.keySet()){
            List<Integer> xSet = map.get(y);
            int len = xSet.size();
            if(len >= 2){
                long ways = (long) len * (len - 1) /2;
                waySum = (waySum + ways) % MOD;
                waySumPow2 = (waySumPow2 + (ways * ways)%MOD)%MOD;
            }
        }
        long tmp1 = (waySum * waySum)%MOD;
        long tmp2 = (tmp1 - waySumPow2 + MOD) % MOD;

        long res = (tmp2 * inverseOf2) % MOD;
        return (int) res;
    }
}