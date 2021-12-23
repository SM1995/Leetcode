class Solution {
    public int singleNumber(int[] nums) {
        int out = nums[0];
        for(int i=1;i<nums.length;i++) out ^= nums[i];
        return out;
    }
}
