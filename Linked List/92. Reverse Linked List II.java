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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;
        int s = left, e = right;
        
        ListNode first = null, second=null;
        ListNode prev = null;
        ListNode curr = head;
        
        while(s>1) {
            prev = curr;
            curr = curr.next;
            s--;
            e--;
        }
        System.out.println(curr.val);
        first = prev;        
        second = curr;
        ListNode temp = null;
        
        while(e>0){
            temp = curr.next;
            curr.next = prev;
            prev=curr;
            curr = temp;
            e--;
        }
        
        if(first!=null){
            first.next = prev;     
        }
        else head = prev;
        second.next = curr; 
        return head;
    }
}
