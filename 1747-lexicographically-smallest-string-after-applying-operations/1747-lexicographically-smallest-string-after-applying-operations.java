class Solution {
    private void reverseRotate(StringBuilder sb, int left, int right){
        while(left < right){
            char ch = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, ch);
            left++;
            right--;
        }
    }
    private String rotate(String s, int b){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        reverseRotate(sb, 0, b-1);
        reverseRotate(sb, b, sb.length()-1);

        return sb.toString();
    }
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        visited.add(s);
        String smallestStr = s;
        while(!q.isEmpty()){
            String curr = q.poll();

            if(curr.compareTo(smallestStr) < 0){
                smallestStr = curr;
            }

            char alpha[] = curr.toCharArray();
            //Add a to each character
            for(int i=1;i<alpha.length;i+=2){
                int newDigit = ((alpha[i] - '0') + a) % 10;
                alpha[i] = (char) (newDigit + '0');
            }
            String org = new String(alpha);
            if(visited.add(org)){
                q.add(org);
            }
            //Rotate String by b 
            String rotateString = rotate(curr, b);
            if(visited.add(rotateString)){
                q.add(rotateString);
            }
        }

        return smallestStr;
    }
}