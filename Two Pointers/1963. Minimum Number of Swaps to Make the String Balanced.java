class Solution {
    public int minSwaps(String s) {
        int out = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[') out++;
            else if(out>0) out--;
        }
        return (out+1)/2;
    }
}
