class Solution {
    private boolean check(String s1, String s2){
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char ch : s1.toCharArray()){
            freq1[ch - 'a']++;
        }
        for(char ch : s2.toCharArray()){
            freq2[ch - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i]){
                return true;
            }
        }
        return false;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(check(ans.get(ans.size()-1), words[i])){
                ans.add(words[i]);
            }
        }
        return ans;
    }
}