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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        
        ListNode curr = temp;
        ListNode tail = temp;
        
        while(n>0) {
            tail = tail.next;
            n--;
        }
        
        System.out.println(tail.val);
        
        while(tail.next!=null){
            curr = curr.next;
            tail = tail.next;
        }
        
        System.out.println(curr.val);
        
        curr.next = curr.next.next;
        return temp.next;
    }
}
