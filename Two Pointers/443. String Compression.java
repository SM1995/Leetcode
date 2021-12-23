class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        
        if(n < 2) return n;
            
        int count = 0;
        //ArrayList<Character> arr = new ArrayList<>();
        count++;
        //arr.add(chars[0]);
        int start = 1;
        
        for(int i=1;i<n;i++){
            char c = chars[i];
            
            if(c==chars[start-1]) {
                //System.out.println(count);
                count++;
            }
            else{
                System.out.println(count);
                if(count>1) {
                    String num = Integer.toString(count);
                    for(int j=0;j<num.length();j++){
                        chars[start++] = num.charAt(j);
                    }
                }
                count = 1;
                chars[start++] = c;
            }
        }
        
        if(count>1) {
            String num = Integer.toString(count);
            for(int i=0;i<num.length();i++){
                chars[start++] = num.charAt(i);
            }
        }
        return start;   
    }
}
