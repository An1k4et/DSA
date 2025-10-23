class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 2){
            StringBuilder temp = new StringBuilder("");
            for(int i=0;i<sb.length()-1;i++){
                int a = sb.charAt(i) - '0';
                int b = sb.charAt(i+1) - '0';
                int sum = (a+b)%10;
                temp.append((char)(sum + '0'));
            }
            sb = temp;
        }
        return sb.charAt(0) == sb.charAt(1);
    }
}