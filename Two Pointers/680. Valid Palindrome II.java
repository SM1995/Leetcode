class Solution {
    public boolean validPalindrome(String s) {
        int l=-1, r=s.length();
        while(++l<--r){
            if(s.charAt(l)!=s.charAt(r)) return isPalindrome(s, l+1, r)||isPalindrome(s, l, r-1);
        }
        return true;
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)==s.charAt(end)){
                start++;end--;
            }
            else return false;
        }
        return true;
    }
}
