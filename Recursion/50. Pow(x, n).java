class Solution {
    public double myPow(double x, int n) {
        
        if(n<0){
            x=1/x;
            n=n*-1;
        }
        /*if(n%2==0) return myPow(x*x,n/2);
        else return myPow(x*x,n/2)*x;*/
        return fast(x,n);
    }
    
    public double fast(double x, int n){
                if(n==0) return 1;

        double half = fast(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }   
    }
}
