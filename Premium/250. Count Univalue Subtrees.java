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
    
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        
        helper(root);
        return count;
    }
    
    public boolean helper(TreeNode root){
        
        boolean out = true;
        if(root == null) return false;
        
        if(root.left==null && root.right == null) {
            count++;
            return true;
        }
        
        if(root.left!=null){
            out = helper(root.left) && root.val == root.left.val && out;
        }
        
        if(root.right!=null){
            out = helper(root.right) && root.val == root.right.val && out;
        }
        
        if(!out) return false;
        count++;
        return true;
    }
}



/*

Approach 1: Depth First Search
Intuition

Given a node in our tree, we know that it is a univalue subtree if it meets one of the following criteria:

The node has no children (base case)
All of the node's children are univalue subtrees, and the node and its children all have the same value
With this in mind we can perform a depth-first-search on our tree, and test if each subtree is uni-value in a bottom-up manner.

Algorithm

public class Solution {
    int count = 0;
    boolean is_uni(TreeNode node) {

        //base case - if the node has no children this is a univalue subtree
        if (node.left == null && node.right == null) {

            // found a univalue subtree - increment
            count++;
            return true;   
        }

        boolean is_unival = true;

        // check if all of the node's children are univalue subtrees and if they have the same value
        // also recursively call is_uni for children
        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
         }

        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }

        // return if a univalue tree exists here and increment if it does
        if (!is_unival) return false;
        count++;
        return true;
    }
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        is_uni(root);
        return count;
    }
}

Complexity Analysis

Time complexity : O(n)O(n).

Due to the algorithm's depth-first nature, the is_uni status of each node is computed from bottom up. When given the is_uni status of its children, computing the is_uni status of a node occurs in O(1)O(1)

This gives us O(1)O(1) time for each node in the tree with O(N)O(N) total nodes for a time complexity of O(N)O(N)

Space complexity : O(H)O(H), with H being the height of the tree. Each recursive call of is_uni requires stack space. Since we fully process is_uni(node.left) before calling is_uni(node.right), the recursive stack is bound by the longest path from the root to a leaf - in other words the height of the tree.


Approach 2: Depth First Search - Pass Parent Values
Algorithm


We can use the intuition from approach one to further simplify our algorithm. Instead of checking if a node has no children, we treat null values as univalue subtrees that we don't add to the count.

In this manner, if a node has a null child, that child is automatically considered to a valid subtree, which results in the algorithm only checking if other children are invalid.

Finally, the helper function checks if the current node is a valid subtree but returns a boolean indicating if it is a valid component for its parent. This is done by passing in the value of the parent node.


public class Solution {
    int count = 0;
    boolean is_valid_part(TreeNode node, int val) {

        // considered a valid subtree
        if (node == null) return true;

        // check if node.left and node.right are univalue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
        if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val)) return false;

        // if it passed the last step then this a valid subtree - increment
        count++;

        // at this point we know that this node is a univalue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.val == val;
    }
    public int countUnivalSubtrees(TreeNode root) {
        is_valid_part(root, 0);
        return count;
    }
}

The above code is a commented version of the code here, originally written by Stefan Pochmann.

Complexity Analysis

Time complexity : O(N)O(N). Same as the previous approach.

Space complexity : O(H)O(H), with H being the height of the tree. Same as the previous approach.
*/
