class Solution {
    public int countCollisions(String directions) {
        char d[] = directions.toCharArray();

        int n = directions.length();
        int i = 0, j=n-1;
        while(i<n && d[i] == 'L'){
            i++;
        }

        while(j>=0 && d[j] == 'R'){
            j--;
        }

        int collisions = 0;
        while(i<=j){
            if(d[i] != 'S'){
                collisions++;
            }
            i++;
        }

        return collisions;
    }
}