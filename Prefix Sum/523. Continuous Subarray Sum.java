class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> hset = new HashMap<>();
        hset.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            sum%=k;
            if(hset.containsKey(sum)) {
                int prev = hset.get(sum);
                if(i-prev>1) return true;
            }
            else hset.put(sum,i);
        }
        return false;
    }
}
