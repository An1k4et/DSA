class Solution {
    private String rotate(String s, int b){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        reverse(sb, 0, b-1);
        reverse(sb, b, sb.length()-1);
        return sb.toString();
    }
    private void reverse(StringBuilder sb, int l, int r){
        while(l < r){
            char ch = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, ch);
            l++;
            r--;
        }
    }
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(s);
        String smallString = s;
        while(!q.isEmpty()){
            String curr = q.poll();

            if(curr.compareTo(smallString) < 0){
                smallString = curr;
            }
            char alpha[] = curr.toCharArray();
            for(int i=0;i<alpha.length;i++){
                if(i%2 != 0){
                    int newVal = ((alpha[i] - '0') + a) % 10;
                    char ch = (char)('0' + newVal);
                    alpha[i] = ch;
                }
            }
            String addCurr = new String(alpha);
            if(visited.add(addCurr)){
                q.add(addCurr);
            }
            String rotateCurr = rotate(curr, b);
            if(visited.add(rotateCurr)){
                q.add(rotateCurr);
            }
        }
        return smallString;
    }
}