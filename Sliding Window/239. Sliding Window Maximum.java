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

/*
Approach 2:
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] right = new int[n];
        int[] left = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
            
        for(int i=1;i<n;i++){
            if(i%k==0) left[i] = nums[i];
            else left[i] = Math.max(left[i-1], nums[i]); 
        }
        
        for(int i=n-2;i>=0;i--){
            if(i%k==k-1) right[i] = nums[i];
            else {
                if(right[i+1]>nums[i]) right[i] = right[i+1];
                else right[i] = nums[i];
            }
            
            //System.out.println(nums[left[i]]);
        }
        
        for(int i=0;i<n;i++){
            System.out.print(right[i]+ " ");
            System.out.println(left[i]);
        }
        
        int[] out = new int[n-k+1];
        for (int i = 0; i < n - k + 1; i++)
            out[i] = Math.max(left[i + k - 1], right[i]);
        
        return out;
    }
}
*/
