class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for(int i=0;i<order.length();i++){
            //System.out.println(order.charAt(i));
            ord[order.charAt(i)-'a'] = i;
        }
        
        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<words[i].length();j++){
                if(j>= words[i+1].length()) {
                    //System.out.println("false");
                    return false;
                }
                char first = words[i].charAt(j);
                char second = words[i+1].charAt(j);
                if(ord[first - 'a'] < ord[second-'a']) {
                    break;
                }
                else if(ord[first - 'a'] == ord[second-'a']) continue;
                else {
                    System.out.println(first);
                    return false;
                }
            }
        }
        return true;
    }
}
