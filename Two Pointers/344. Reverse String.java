class Solution {
    public void reverseString(char[] s) {
        
        int n = s.length-1;
        
        for(int i=0;i<=n/2;i++){
            char temp = s[i];
            s[i] = s[n-i];
            s[n-i] = temp;
        }
        
        /*
        //Approach 2:
        class Solution {
            public void reverseString(char[] s) {
                helper(s,0,s.length-1);

            }

            public void helper(char[] s, int start, int end){

                if(start>=end) return;

                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
                helper(s, start+1, end-1);
            }
        }
        */
    }
    
}
