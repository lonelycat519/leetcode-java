/* Given a linked list, remove the nth node from the end of list and return its head.
 
 For example,
 Given linked list: 1->2->3->4->5, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5.
 
 Note:
 Given n will always be valid.
 Try to do this in one pass. */

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre;
        ListNode now = head;
        ListNode nth;
        
        if(now==null) return head;
        
        for(int i=0; i<n-1; i++){
            if(now.next!=null) now = now.next;
            else return head;
        }
        
        nth = now;
        now = head;
        pre = head;
        
        while(nth.next!=null){
            nth = nth.next;
            pre = now;
            now = now.next;
        }
        
        if(now == head) head = head.next;
        else pre.next = now.next;
        
        return head;
    }
}
