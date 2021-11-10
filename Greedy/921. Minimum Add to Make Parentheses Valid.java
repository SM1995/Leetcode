class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;
        int diff=0, open=0,close=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') open++;
            else if(s.charAt(i)==')') {
                close++;
                //System.out.println(close);
                if(close>open){
                    diff+=close-open;
                    close=open;
                    System.out.println(diff);
                }
            }
        }
        //System.out.println(close);
        //System.out.println(open);
        //System.out.println(diff);
        diff+=(open-close);
        return Math.abs(diff);
    }
}
