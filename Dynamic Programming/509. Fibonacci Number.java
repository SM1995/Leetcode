class Solution {
    
    public int wrap(int n, int[] out){
        for(int i=2;i<=n;i++){
            out[i] = out[i-1]+out[i-2];
        }
        return out[n];
    }
    
    public int fib(int n) {
        int[] out = new int[n+1];
        out[0] = 0;
        if(n > 0) out[1] = 1;
        if(n<2) return out[n];
        return wrap(n, out);
    }
}
