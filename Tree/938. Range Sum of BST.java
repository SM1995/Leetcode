class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty()|| root!=null){
            if(root!=null) {
                st.push(root);
                root = root.left;           
            }
            else{
                root = st.pop();
                if(root.val>=low && root.val<=high) sum+=root.val;
                root = root.right;
            }
        }
        return sum;
    }
}
