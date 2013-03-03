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
        
        ListNode head = new ListNode(0);
        ListNode now1 = l1;
        ListNode now2 = l2;
        
        if(now1.val<=now2.val){
            head.val = now1.val;
            now1 = now1.next;
        }   else{
            head.val = now2.val;
            now2 = now2.next;
        }
        
        ListNode now = head;
        
        while(now1!=null&now2!=null){
            if(now1.val<=now2.val){
                now.next = new ListNode(now1.val);
                now1 = now1.next;
            }   else{
                now.next = new ListNode(now2.val);
                now2 = now2.next;
            }
            now = now.next;
        }
        
        if(now1!=null){
            while(now1!=null){
                now.next = new ListNode(now1.val);
                now = now.next;
                now1 = now1.next;
            }
        }   else if(now2!=null){
            while(now2!=null){
                now.next = new ListNode(now2.val);
                now = now.next;
                now2 = now2.next;
            }
        }
        
        return head;
    }
}eturn head;
    }
}
