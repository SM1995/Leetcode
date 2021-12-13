class SparseVector {
    HashMap<Integer, Integer> hmap = new HashMap<>();
    int n;
    
    SparseVector(int[] nums) {
        n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0) hmap.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int i=0; i<n; i++){
            if(hmap.containsKey(i) && vec.hmap.containsKey(i)){
                System.out.println(hmap.get(i));
                sum = sum + hmap.get(i) * vec.hmap.get(i);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
