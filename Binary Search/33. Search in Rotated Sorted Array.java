class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1) return nums[0]==target ? 0 : -1;
        
        int start = 0, end = nums.length-1;
        System.out.print(end);
        
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>=nums[start]){
                System.out.print(end+" ");
                if(nums[start]<=target && nums[mid]>=target) end = mid;
                else start = mid+1;
                System.out.print(start+" ");
                System.out.println(end);
            }
            else{
                if(nums[mid]<=target && nums[end]>=target) start = mid;
                else end = mid-1;
                System.out.print("start"+start+" ");
                System.out.println(end);
            }
        }
        return -1;
    }
}
