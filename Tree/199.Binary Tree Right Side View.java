class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        
        if(root==null) return out;
        
        Queue<TreeNode> bst = new LinkedList<>();
        bst.add(root);
        while(!bst.isEmpty()){
            int size = bst.size();
            
            for(int i=0;i<size;++i){
                TreeNode curr = bst.poll();
                if(i==size-1) out.add(curr.val);
                System.out.println(curr.val);       
                if(curr.left!=null) bst.add(curr.left);         
                if(curr.right!=null) bst.add(curr.right);
                
            }
        }   
        return out;
    }
}
