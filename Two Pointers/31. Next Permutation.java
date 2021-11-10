class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length>1){
            int i=nums.length-2;
            while(i>=0 && nums[i]>=nums[i+1]){
                i--;
            }
            System.out.println(i);
            if(i>=0){
                int k=findNextLargest(nums, i);
                swap(nums, i, k);
            }
            reverse(nums,i+1);
        }
    }
    
    public int findNextLargest(int[] nums, int i){
        int k=i+1;
        int max = nums[i+1];
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]>nums[i] && nums[j]<=max){
                max = nums[j];
                k=j;
            }
        }
        return k;
    }
    
    public void swap(int[] nums, int i, int k){
        System.out.println(nums[k]);
        System.out.println(nums[i]);
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
    
    public void reverse(int[] nums, int i){
        int j=nums.length-1;
        while(i<j){
            swap(nums, i, j);
            i++;j--;
        }
    }
}
