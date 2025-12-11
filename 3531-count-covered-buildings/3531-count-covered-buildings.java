class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> map1 = new HashMap<>();
        Map<Integer, TreeSet<Integer>> map2 = new HashMap<>();

        for(int building[]:buildings){
            map1.computeIfAbsent(building[1],k-> new TreeSet<>()).add(building[0]);
            map2.computeIfAbsent(building[0],k-> new TreeSet<>()).add(building[1]);
        }

        int count = 0;

        for(int building[]:buildings){
            int x = building[0], y = building[1];
            TreeSet<Integer> temp1 = map1.get(y);
            TreeSet<Integer> temp2 = map2.get(x);

            if(temp1.lower(x) != null && temp1.higher(x) != null &&
               temp2.lower(y) != null && temp2.higher(y) != null){
                count++;
               }
        }
        return count;
    }
}