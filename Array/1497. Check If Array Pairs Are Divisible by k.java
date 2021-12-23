class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        
        for(int i=0;i<arr.length;i++){
            int temp = arr[i]%k;
            if(temp<0) temp+=k;
            freq[temp] += 1;
        }
        
        if(freq[0]%2!=0) return false;
        
        int i=1;
        int j=k-1;
        while(i<=j){
            System.out.println(i);
            
            if(freq[i]!=freq[j]) return false;
            i++;j--;
        }
        
        return true;
    }
}
