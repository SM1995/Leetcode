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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        else if(root.left==null && root.right==null) return root.val==targetSum ? true : false;
        
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,root.val));
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> p = queue.remove();
            TreeNode node = p.getKey();
            Integer value = p.getValue();
            
            if(value==targetSum && node.left==null && node.right==null) return true;
            //value+=node.val;
            if(node.left!=null) queue.add(new Pair<>(node.left, value+node.left.val));
            if(node.right!=null) queue.add(new Pair<>(node.right, value+node.right.val));
        }
        
        return false;
    }
}
