class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = word.length();
        
        if(!sequence.contains(word)) return 0;
        int count = 0;
        boolean con = false;
        int i=0;
        int out = Integer.MIN_VALUE;
        
        for(int j=0;j<sequence.length();j++){
            i=j;
            count = 0;
            while(i<=sequence.length()-n){
                //System.out.println(i);
                if(sequence.substring(i,i+n).equals(word)){
                    i = i+n;
                    System.out.println(count);
                    if(con) count++;
                    else {
                        count = 1;
                        con = true;
                    }
                } 
                else {
                    con = false;
                    i++;
                }
                out = Math.max(out,count);
            }
        }
        
        return out;
    }
}
