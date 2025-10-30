class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 2){
            int n = sb.length();
            for(int i=0;i<n-1;i++){
                int a = sb.charAt(i) - '0';
                int b = sb.charAt(i+1) - '0';
                int ans = (a+b)%10;
                char ch = (char) (ans + '0');
                sb.setCharAt(i, ch);
            }
            sb.deleteCharAt(n-1);
        }
        return sb.charAt(0) == sb.charAt(1);
    }
}