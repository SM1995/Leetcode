class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> hmap.get(a)-hmap.get(b));
        
        for(int i=0; i<nums.length; i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }
        
        for(int keys:hmap.keySet()){
            //System.out.println(keys);
            pq.add(keys);
            if(pq.size()>k) pq.poll();
        }
        
        int[] out = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            out[i] = pq.poll();
            i++;
        }
        
        return out;
    }
}
