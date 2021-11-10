class Solution {
    public int sumNumbers(TreeNode root) { 
        int sum = 0, value = 0;
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        TreeNode curr = null;
        st.push(new Pair(root, 0));
        while(!st.isEmpty()){
            Pair<TreeNode, Integer> p = st.pop();
            curr = p.getKey();
            value = p.getValue();
            
            if(curr!=null){
                value = value*10 + curr.val;
                if(curr.left==null && curr.right==null) sum+=value;
                else{
                    st.push(new Pair(curr.left,value));
                    st.push(new Pair(curr.right, value));
                }
            }
        }
        return sum;
    }
    
}
