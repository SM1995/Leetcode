class Solution {
    public String minRemoveToMakeValid(String s) {
        int open=0,close=0;
        ArrayList<Integer> remove = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') open++;
            else if(s.charAt(i)==')'){
                close++;
                if(close>open){
                    remove.add(i);
                    close--;
                }
            }
        }
        open=0;close=0;
        for(int i=s.length()-1;i>=0;i--){
            if(remove.contains(i)) continue;
            if(s.charAt(i)==')') close++;
            else if(s.charAt(i)=='('){
                open++;
                if(open>close){
                    remove.add(i);
                    open--;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for( int i=0;i<s.length();i++){
            if(!remove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();        
    }
}
