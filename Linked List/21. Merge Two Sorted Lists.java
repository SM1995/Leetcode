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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null) return list2;
        
        else if(list2==null) return list1;
        
        else if(list1.val<=list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        
       /* 
       
       //Approach 2:
        
        ListNode out = null, temp = null;
        
        while(list1!=null && list2!=null){
            ListNode curr = null;
            if(list1.val<=list2.val){
                curr = list1;
                list1 = list1.next;
            }
            else{
                curr = list2;
                list2 = list2.next;
            }
            if(out==null) {
                out = curr;
                temp = curr;
            }
            else{
                temp.next = curr;
                temp = temp.next;
            }
        }
        
        while(list1!=null){
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }
        while(list2!=null){
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }
        
        return out;*/
    }
}
