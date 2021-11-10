class Solution {
    int[] prefixSums;
    int totalSum;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        int sum = 0;
        for(int i=0;i<w.length;i++){
            sum+=w[i];
            prefixSums[i]=sum;
        }
        totalSum = sum;
    }
    
    public int pickIndex() {
        double index = totalSum*Math.random();
        int low=0, high=prefixSums.length;
        while(low<high){
            int mid = low + (high-low)/2;
            if(index<=prefixSums[mid]) high=mid;
            else low = mid+1;            
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
