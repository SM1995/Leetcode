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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root==null) return out;
        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
        hmap = helper(root, hmap);
        ArrayList<Integer> arr = new ArrayList<>(hmap.keySet());
        Collections.sort(arr);
                
        for(int i:arr){
            out.add(hmap.get(i));
        }
        return out;
    }
    
    
    public HashMap<Integer, ArrayList<Integer>> helper(TreeNode root, HashMap<Integer, ArrayList<Integer>> hmap){
        Queue<Pair<Integer,TreeNode>> stack = new LinkedList<>();
        
        TreeNode curr = root;
        int level = 0;
        stack.add(new Pair(level,curr));
        while(!stack.isEmpty()){
            Pair<Integer,TreeNode> pair = stack.remove();
            curr = pair.getValue();
            level = pair.getKey();
            if(!hmap.containsKey(level)){
                hmap.put(level,new ArrayList<Integer>());
            }
            hmap.get(level).add(curr.val);
            if(curr.left!=null) stack.add(new Pair(level-1,curr.left));
            if(curr.right!=null) stack.add(new Pair(level+1,curr.right));
        }
        
        return hmap;
    }
}
