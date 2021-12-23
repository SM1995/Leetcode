/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return sort(left,right);
    }
    
    public ListNode findMid(ListNode head){
        
        ListNode midPrev = null;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            midPrev = (midPrev==null) ? head : midPrev.next;
        }
        
        ListNode out = midPrev.next;
        midPrev.next = null;
        return out;
    }
    
    public ListNode sort(ListNode head, ListNode mid){
        ListNode out = new ListNode();
        ListNode temp = out;
        
        while(head!=null && mid!=null){
            if(head.val<mid.val){
                temp.next = head;
                head = head.next;
                temp = temp.next;
            } 
            else{
                temp.next = mid;
                mid = mid.next;
                temp = temp.next;
            } 
        }    
        
        temp.next = mid!=null ? mid : head;
        return out.next;
    }
}
