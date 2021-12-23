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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode prev = null, curr = null;
        
        prev = head;
        curr = head.next;
        ListNode temp = curr.next;
        
        curr.next = prev;
        prev.next = null;
        
        prev = curr;
        curr = temp;
        while(curr!=null){
            temp = curr.next;
            System.out.println(prev.val);
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
