class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> out = new ArrayList<>();
            
        HashMap<String, ArrayList<String>> hmap = new HashMap<>();
        for(String s:strings){
            int offset = s.charAt(0)-'a';
            String key = "";
            
            for(int i=0;i<s.length();i++){
                char c = (char)(s.charAt(i)-offset);
                if(c < 'a') c+=26;
                key+=c;
            }
            
            if(hmap.containsKey(key)){
                hmap.get(key).add(s);
            }
            else {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(s);
                hmap.put(key,arr);
            }
        }
        
        for(String s: hmap.keySet()){
            out.add(hmap.get(s));
        }
        
        return out;
    }
}
