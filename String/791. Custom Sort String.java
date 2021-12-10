class Solution {
    public String customSortString(String order, String s) {        
        int[] count = new int[26];
        for(int i=0; i<s.length();i++){
            count[s.charAt(i)-'a'] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length();i++){
            char c = order.charAt(i);
            if(!s.contains(Character.toString(c))) continue;
            int j=0;
            while(j<count[c-'a']){
                sb.append(c);
                j++;
            }
        }
        
        for(int i=0; i<s.length();i++){
            String c = s.substring(i,i+1);
            if(order.contains(c)) continue;
            sb.append(c);
        }
        
        return sb.toString();        
    }
}
