public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binary(1, n);
    }
    
    public int binary(int start, int end){
        //int mid = (end - start)/2;
        while(start<end){
            int mid = start + (end - start)/2;
            System.out.println(mid);
            if(isBadVersion(mid)){
                System.out.println(mid);
                end = mid;
            }
            else {
                start = mid+1;
                System.out.println("mid "+ mid +" " + start + " " + end);
            }
        }
        return start;
    }
}
