class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        int start = 0;
        int end = x/2;
        long num;
        while(start<=end){
            int mid = (start+end)/2;
            num = (long)mid*mid;
            if(num==x) return mid;
            else if(num>x) end = mid-1;
            else {
                start = mid+1;
            }
        }
        return end;
    }
}
