class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(x>0){
            arr.add(x%10);
            x = x/10;
        }
        
        int n = arr.size()-1;
        int i = 0;
        
        while(i<n){
            if(arr.get(i)!=arr.get(n)) return false;
            i++;n--;
        }
        
        return true;
    }
}
