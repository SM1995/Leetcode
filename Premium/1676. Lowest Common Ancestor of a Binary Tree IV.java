/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        
        HashSet<TreeNode> nodeSet = new HashSet<>(Arrays.asList(nodes));
        helper(root, nodeSet);
        
        return ans;
    }
    
    public int helper(TreeNode root, HashSet<TreeNode> nodes){
        
        if(root==null) return 0;
        
        int count = 0;
        int left = helper(root.left, nodes);
        int right = helper(root.right, nodes);
        
        count = left+right;
        if(nodes.contains(root)) count++;
        
        if(count>=nodes.size() && ans==null){
            ans = root;
        }
        
        return count;
    }
}



/*



*/
