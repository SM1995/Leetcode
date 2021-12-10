class Solution {
    public int maximumSwap(int num) {
        int temp = num;
        int prev=0,curr=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp>0){
           arr.add(temp%10);
            temp/=10;
       }
        Collections.reverse(arr);
        int i=0;
        for(; i<arr.size()-1; i++){
            if(arr.get(i)<arr.get(i+1)) break;
        }
        
        System.out.println(i);
        if(i==arr.size()-1) return num;
        
        int maxV = arr.get(i++);
        int maxI = i;
        for(; i<=arr.size()-1; i++){
            if(arr.get(i)>=maxV){
                maxV = arr.get(i);
                maxI = i;
            }
        }
        int first = 0;
        for(int j=0; j<arr.size(); j++){
            if(arr.get(j)<maxV) {
                first = j;
                break;
            }
        }
        
        temp = arr.get(first);
        arr.set(first, arr.get(maxI));
        arr.set(maxI, temp);
        
        int output = 0;
        for(int j=0; j<arr.size(); j++){
            output = output*10+arr.get(j);
        }
        
        return output;
    }
}
