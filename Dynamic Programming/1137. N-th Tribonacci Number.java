class Solution {
    
    public int wrap(int n, int[] out){
        for(int i=3;i<=n;i++){
            out[i] = out[i-1]+out[i-2]+out[i-3];
        }
        return out[n];
    }
    
    public int tribonacci(int n) {
        int[] out = new int[n+1];
        out[0] = 0;
        if(n > 0) {
            out[1] = 1;
            if(n>1)out[2] = 1;
        }
        if(n<3) return out[n];
        return wrap(n, out);
    }
}
