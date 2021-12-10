/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    
    ArrayList<TreeNode> arr = new ArrayList<>();
    int index = -1;
    
    public BSTIterator(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty()|| curr!=null){
            if(curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            else{
                curr = stack.pop();
                arr.add(curr);
                //System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }
    
    public int next() {
        return arr.get(++index).val;
    }
    
    public boolean hasNext() {
        return index+1<arr.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
