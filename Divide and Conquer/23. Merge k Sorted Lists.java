class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> ln = new PriorityQueue<ListNode>((a, b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            ListNode curr = lists[i];
            while(curr!=null){
                ln.add(curr);
                curr=curr.next;
            }
        }
        ListNode temp = null, output = null;
        if(!ln.isEmpty()) {
            temp = ln.remove(); output = temp; 
        }//= ln.remove();
        while(!ln.isEmpty()){
            temp.next = ln.remove();
            temp = temp.next;
        }
        if(temp!=null) temp.next=null;
        return output;
    }
}
