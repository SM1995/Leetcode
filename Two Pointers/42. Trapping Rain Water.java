class Solution {
    public int trap(int[] height) {
        
        int left = 0, right = height.length-1;
        int left_max = 0;
        int right_max = 0;
        int ans = 0;
        while(left < right){
            if(height[left]<=height[right]){
                //System.out.println(left_max);
                if(height[left]>=left_max) {
                    left_max = height[left];
                System.out.println(height[left]);
                //System.out.println(left_max);
                }
                else{
                    //System.out.println(height[left]);
                    ans+=(left_max-height[left]);
                }
                    ++left;
            }
            else{
                //System.out.println(right_max);
                if(height[right]>=right_max) {
                    right_max = height[right];
                                             }
                else{
                    //System.out.println(height[right]);
                    ans+=(right_max-height[right]);
                }
                    --right;
            }
        }
        return ans;
    }
}
