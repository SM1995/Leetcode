class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (int)(Math.pow(b[0],2)+Math.pow(b[1],2))-(int)(Math.pow(a[0],2)+Math.pow(a[1],2)));
        
        for(int i=0;i<points.length;i++){          
            if(pq.size()>=k){
                
                if((Math.pow(pq.peek()[0],2)+Math.pow(pq.peek()[1],2))> (Math.pow(points[i][0],2)+Math.pow(points[i][1],2))){
                    pq.remove();
                    pq.add(points[i]);
                }
            }
            else{
                //System.out.println(points[i][0]);
                pq.add(points[i]);
            }
        }
        
        int[][] out = new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            out[i] = pq.remove();
            i++;
        }
        
        return out;
    }
}
