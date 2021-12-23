class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        int[] out = new int[n-k+1];
        int index=0;
        
        for(int i=0;i<k;i++){
            while(!q.isEmpty() && q.getFirst()==i-k) q.removeFirst();
            
            while(!q.isEmpty() && nums[q.getLast()]<nums[i]) q.removeLast();
            
            q.addLast(i);
            if(nums[i]>nums[index]) index = i;
        }
        q.addFirst(index);
        out[0] = nums[index];
        for(int i=k;i<n;i++){
            
            while(!q.isEmpty() && q.getFirst()==i-k) q.removeFirst();
            
            while(!q.isEmpty() && nums[q.getLast()]<nums[i]) q.removeLast();
            
            q.addLast(i);
            out[i-k+1] = nums[q.getFirst()];
        }
        
        return out;
    }
}
