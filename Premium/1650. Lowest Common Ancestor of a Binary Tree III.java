/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        Node a = p;
        Node b = q;
        
        while(p!=q){
            p = p==null ? b : p.parent;
            q = q==null ? a : q.parent;
        }
        return p;
    }
}
