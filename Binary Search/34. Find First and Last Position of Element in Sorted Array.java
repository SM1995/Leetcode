class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int start = 0, end = nums.length-1;
        int[] out = new int[2];
        
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                out[0] = mid;
                end = mid-1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else start = mid+1;
        }
        if(nums[out[0]]!=target) out[0] = -1;
        
        start = 0; end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                out[1] = mid;
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else start = mid+1;
        }
        if(nums[out[1]]!=target) out[1] = -1;
        
        return out;
    }
}
