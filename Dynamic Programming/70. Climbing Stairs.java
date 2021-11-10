class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        return climbStairshelper(n, arr);
    }
    public int climbStairshelper(int n, int[] arr){
        arr[n]=1;
        if(n>0) arr[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            arr[i] = arr[i+1] + arr[i+2]; 
        }
        return arr[0];
    }
}
