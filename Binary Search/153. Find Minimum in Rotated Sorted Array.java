class Solution {
    public int findMin(int[] nums) {
        int start = 0,end = nums.length-1;
        if(nums.length==1) return nums[0];
        if(nums[start]<nums[end]) return nums[start];
            
        while(start<=end){
            System.out.print(start);
            System.out.println(end);
            int mid = (start+end)/2;
                   
            if(nums[mid]>nums[mid+1]) return nums[mid+1];
            if(nums[mid-1]>nums[mid]) return nums[mid];
    
            else if(nums[mid]>nums[0])
                start = mid+1;  
            else end = mid;
        }
        
        return nums[start];
    }
}
