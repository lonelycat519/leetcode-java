/* Given a linked list, swap every two adjacent nodes and return its head.
 
 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.
 
 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. */

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
    public ListNode swapPairs(ListNode head) {
        if(head==null)  return null;
        if(head.next==null) return head;
        
        ListNode result = head.next;
        
        // Swap
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode now = pre;
        ListNode pos = head.next;
        ListNode temp = head;
        
        while(now.next!=null){
            if(now.next.next!=null){
                pre = now;
                now = now.next;
                pos = now.next;
                
                temp = pos.next;
                pos.next = now;
                now.next = temp;
                pre.next = pos;
            }   else
                break;
        }
        // Finish
        
        return result;
    }
}


// Second Version: consider 2 Node as a unit
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode result = head.next;
        
        // Do something...
        ListNode now = head.next.next;
        ListNode previous = head.next;
        while(now!=null && now.next!=null){
            // Swap
            previous.next = now.next;
            ListNode temp = now.next.next;
            now.next.next = now;
            now.next = temp;
            
            previous = now;
            now = now.next;
        }
        
        head.next = result.next;
        result.next = head;
        
        return result;
    }
}
