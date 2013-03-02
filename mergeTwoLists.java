/* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)    return l2;
        if(l2==null)    return l1;
        
        ListNode head;
        ListNode now1;
        ListNode now2;
        
        if(l1.val<l2.val){
            head = l1;
            now2 = l2;
        }   else{
            head = l2;
            now2 = l1;
        }
        now1 = head;
        
        while(now1.next!=null&now2!=null){
            if(now1.next.val<=now2.val){
                now1 = now1.next;
            }   else{
                ListNode temp = now1.next;
                now1.next = now2;
                now1.next.next = temp;
                now2 = now2.next;
            }
        }
        if(now2!=null)
            now1.next = now2;
        
        return head;
    }
}
