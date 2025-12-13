class Solution {
    public static class Pair implements Comparable<Pair>{
        int order;
        String code;

        Pair(String code, int order){
            this.order = order;
            this.code = code;
        }

        @Override
        public int compareTo(Pair other){
            if(this.order != other.order){
                return Integer.compare(this.order, other.order);
            }
            return this.code.compareTo(other.code);
        }
    }
    private boolean checkValid(String s){
        if(s.equals("") && s.isEmpty()){
            return false;
        }
        for(char ch : s.toCharArray()){
            if(!Character.isLetterOrDigit(ch) && ch != '_'){
                return false;
            }
        }
        return true;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);

        List<Pair> list = new ArrayList<>();
        for(int i=0;i<code.length;i++){
            if(isActive[i] 
               && map.containsKey(businessLine[i])
               && checkValid(code[i])){

                Pair p = new Pair(code[i], map.get(businessLine[i]));
                list.add(p);
            }
        }

        Collections.sort(list);

        List<String> result = new ArrayList<>();
        for(Pair p: list){
            result.add(p.code);
        }
        return result;
    }
}