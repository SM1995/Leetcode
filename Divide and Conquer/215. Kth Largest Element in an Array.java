class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k) pq.add(nums[i]);
            else{
                if(pq.peek()<nums[i]){
                    System.out.println(pq.remove());
                    pq.add(nums[i]);
                }
            }
        }
        return pq.remove();
    }
}

/*
Approach 2:
class Solution {
    
    int[] nums;
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        return quick(0, n-1, n-k);
    }
    
    public int partition(int start, int end, int pivot_index){
        
        int pivot = this.nums[pivot_index];
        swap(pivot_index, end);
        int index = start;
                
        for(int i=start;i<=end;i++){
            if(this.nums[i]<pivot){
                swap(index, i);
                index++;
            }
        }        
        swap(index, end);
        return index;        
    }
    
    public int quick(int start, int end, int k){
        
        if(start==end) return this.nums[start];  
        
        Random random = new Random();
        int pivot = start + random.nextInt(end-start);
        pivot = partition(start, end, pivot);
        
        System.out.println(pivot);
        
        if(pivot==k) return this.nums[k];
        else if(k>pivot) return quick(pivot+1, end, k);
        else return quick(start, pivot-1, k);
    }
    
    public void swap(int i, int j){
        int temp = this.nums[i];
        this.nums[i] = this.nums[j];
        this.nums[j] = temp;
    }
}
*/
