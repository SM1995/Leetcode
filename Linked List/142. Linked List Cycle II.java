/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        HashSet<ListNode> hset = new HashSet<>();
        
        while(fast!=null){
            if(hset.contains(fast)) return fast;
            hset.add(fast);
            fast = fast.next;
        }
        
        return null;
    }
}
