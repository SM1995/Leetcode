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
    
    List<List<Integer>> rank = new ArrayList<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        height(root);
        return rank;
    }
    
    public int height(TreeNode root){
        
        if(root==null) return -1;
        
        int leftH = height(root.left);
        int rightH = height(root.right);
        
        int currH = Math.max(leftH, rightH) + 1;
        
        if(rank.size()==currH){
            rank.add(new ArrayList<>());
        }
        
        rank.get(currH).add(root.val);
        
        return currH;
    }
}


/*

Approach 1: DFS (Depth-First Search) with sorting
Intuition

The order in which the elements (nodes) will be collected in the final answer depends on the "height" of these nodes. The height of a node is the number of edges from the node to the deepest leaf. The nodes that are located in the ith height will be appear in the ith collection in the final answer. For any given node in the binary tree, the height is obtained by adding 1 to the maximum height of any children. Formally, for a given node of the binary tree \text{root}root, it's height can be represented as

\text{height(root)} = \text{1} + \text{max(height(root.left), height(root.right))}height(root)=1+max(height(root.left), height(root.right))

Where \text{root.left}root.left and \text{root.right}root.right are left and right children of the root respectively

Algorithm

In our first approach, we'll simply traverse the tree recursively in a depth first search manner using the function int getHeight(node), which will return the height of the given node in the binary tree. Since height of any node depends on the height of it's children node, hence we traverse the tree in a post-order manner (i.e. height of the childrens are calculated first before calculating the height of the given node). Additionally, whenever we encounter a null node, we simply return -1 as it's height.

Next, we'll store the pair (height, val) for all the nodes which will be sorted later to obtain the final answer. The sorting will be done in increasing order considering the height first and then the val. Hence we'll obtain all the pairs in the increasing order of their height in the given binary tree.

Attached below is the video which shows the calculation of height in a height-first-search manner for the binary tree given in the example.

class Solution {
    private List<Pair<Integer, Integer>> pairs;
    
    private int getHeight(TreeNode root) {
        
        // return -1 for null nodes
        if (root == null) return -1;
        
        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        // based on the height of the left and right children, obtain the height of the current (parent) node
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // collect the pair -> (height, val)
        this.pairs.add(new Pair<Integer, Integer>(currHeight, root.val));

        // return the height of the current node
        return currHeight;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.pairs = new ArrayList<>();
        
        getHeight(root);
        
        // sort all the (height, val) pairs
        Collections.sort(this.pairs, Comparator.comparing(p -> p.getKey()));
        
        int n = this.pairs.size(), height = 0, i = 0;

        List<List<Integer>> solution = new ArrayList<>();
        
        while (i < n) {
            List<Integer> nums = new ArrayList<>();
            while (i < n && this.pairs.get(i).getKey() == height) {
                nums.add(this.pairs.get(i).getValue());
                i++;
            }
            solution.add(nums);
            height++;
        }
        return solution;
    }
}

Complexity Analysis

Time Complexity: Assuming NN is the total number of nodes in the binary tree, traversing the tree takes O(N)O(N) time. Sorting all the pairs based on their height takes O(N \log N)O(NlogN) time. Hence overall time complexity of this approach is O(N \log N)O(NlogN)

Space Complexity: O(N)O(N), the space used by pairs. solution also requires O(N)O(N) space however the output does not count towards the space complexity.

Approach 2: DFS (Depth-First Search) without sorting
We've seen in approach 1 that there is an additional sorting that is being performed, which increases the overall time complexity to O(N \log N)O(NlogN). The question we can ask here is, can we do better than this? To answer this, we try to remove the sorting by directly placing all the values in their respective positions, i.e. instead of using the pairs array to collect all the (height, val) pairs and then sorting them based on their heights, we'll directly obtain the solution by placing each element (val) to its correct position in the solution array. To clarify, in the given binary tree, [4, 3, 5] goes into the first position, [2] goes into the second position and [1] goes into the third position in the solution array.

To do this, we modify our getHeight method to directly insert the node's value in the solution array at the correct location. Solution array is kept empty in the beginning and as we encounter elements with increasing height, we'll keep increasing the size of the solution array to accomodate for these elements. For example, if our solution array currently is [[4, 3, 5]] and if we want to insert 2 at the second position, we first create the space for 2 by increasing the size of the solution array by 1 and then insert 2 at it's correct location.

[[4, 3, 5]] -> [[4, 3, 5], []] # increase the size of solution array

[[4, 3, 5], []] -> [[4, 3, 5], [2]] # insert 2 at it's correct location

Below is the implementation of the above mentioned approach.

class Solution {
    
    private List<List<Integer>> solution;
    
    private int getHeight(TreeNode root) {
        
        // return -1 for null nodes
        if (root == null) {
            return -1;
        }
        
        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if (this.solution.size() == currHeight) {
            this.solution.add(new ArrayList<>());
        }
        
        this.solution.get(currHeight).add(root.val);
        
        return currHeight;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.solution = new ArrayList<>();
        
        getHeight(root);
        
        return this.solution;
    }
}

Complexity Analysis

Time Complexity: Assuming NN is the total number of nodes in the binary tree, traversing the tree takes O(N)O(N) time and storing all the pairs at the correct position also takes O(N)O(N) time. Hence overall time complexity of this approach is O(N)O(N).

Space Complexity: O(N)O(N), the space used by solution array.

*/
