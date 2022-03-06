class Solution {
    
    
    public boolean confusingNumber(int n) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,0);
        hmap.put(1,1);
        hmap.put(6,9);
        hmap.put(8,8);
        hmap.put(9,6);
        
        int num = n;
        int curr = 0;
        
        while(num>0){
            int temp = num%10;
            if(!hmap.containsKey(temp)) return false;
            
            curr = curr*10 + hmap.get(temp);
            num = num/10;
        }
        
        if(curr!=n) return true;
        return false;
    }
}
