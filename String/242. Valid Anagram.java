class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        for(char c: s.toCharArray()){
            if(hmap.containsKey(c)){
                hmap.put(c,hmap.get(c)+1);
            }
            else hmap.put(c,1);
        }
        
        System.out.println(hmap);
        for(char c: t.toCharArray()){
            if(!hmap.containsKey(c)) return false;
            else{
                hmap.put(c,hmap.get(c)-1);
            }
        }
        
        System.out.println(hmap);
        for(Character c: hmap.keySet()){
            if(hmap.get(c)>0) return false;
        }
        
        return true;
    }
}
