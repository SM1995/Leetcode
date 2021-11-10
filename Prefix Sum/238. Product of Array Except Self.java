class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] answer = new int[nums.length];
        int[] temp = new int[nums.length];
        answer[0] = 1;
        temp[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        
        for(int i=nums.length-2;i>=0;i--){
            temp[i] = temp[i+1]*nums[i+1];
        }
        
        for(int i=0;i<nums.length;i++){
            answer[i] = answer[i]*temp[i];
        }
        
        return answer;
        
    }
}
