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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hset = new HashSet<>();
        ListNode curr = head;
        while (curr!=null){
            if(hset.contains(curr)) return true;
               hset.add(curr);
               curr=curr.next;
            }
        return false;
    }
}
