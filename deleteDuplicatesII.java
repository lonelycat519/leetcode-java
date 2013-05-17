/* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3. */

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)  return null;
        if(head.next==null) return head;
        
        ListNode now = head;
        ListNode pre = head;
        int val = head.val;
        boolean headRep = false;
        
        if(head.val==head.next.val)
            headRep = true;
        while(now.next!=null){
            if(now.val==now.next.val){
                if(now==head){
                    val = head.val;
                    head=head.next;
                    pre = head;
                }   else{
                    val = now.val;
                    pre.next = now.next;
                }
            }   else{
                if(now.val==val){
                    pre.next = now.next;
                }   else{
                    pre = now;
                }
            }
            now = now.next;
        }
        
        if(now.val==val)
            pre.next=null;
            
        if(headRep)
            return head.next;
        else
            return head;
    }
}


// Version 2
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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return null;            
            
        ListNode h = new ListNode(0);
        h.next = head;
        
        ListNode previous = h;
        ListNode current = h.next;
        int val = current.val;
        boolean flag = false;
        
        while(current.next!=null) {
            if(current.next.val == val) {
                flag = true;
                current = current.next;
                previous.next = current;
            } else {
                if(current.val == val && flag == true) {
                    previous.next = current.next;
                    current = current.next;
                } else {
                    previous = current;
                    current = current.next;                    
                }
                val = current.val;
                flag = false;
            }
        }
        
        if(current.val == val && flag == true)
            previous.next = current.next;
          
        return h.next;
    }
}
