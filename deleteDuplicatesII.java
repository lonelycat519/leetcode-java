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
