class Solution {
    public int findPeakElement(int[] nums) {
        return binSearch(nums, 0, nums.length-1);
    }
    
    public int binSearch(int[] nums, int start, int end){
        if(start==end) return start;
        int mid = start + (end-start)/2;
        if(nums[mid]>nums[mid+1]) return binSearch(nums, start, mid);
        return binSearch(nums, mid+1, end);
    }
}
