class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int great=0;
        for(int i=heights.length-1; i>=0; i--){
            if(heights[i]>great){
                great=heights[i];
                st.push(i);
            }
        }
        int[] out = new int[st.size()];
        for(int i=0;i<out.length;i++){
            out[i] = st.pop();
        }
        return out;
    }
}
