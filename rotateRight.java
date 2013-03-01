/* Given a list, rotate the list to the right by k places, where k is non-negative.
 
 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
*/
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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null)  return null;
        if(head.next==null | n==0) return head;
        
        ListNode now = head;
        
        for(int i=0; i<n-1; i++){
            if(now.next==null)  now = head;
            else now = now.next;
        }
        
        ListNode nth = now;
        ListNode pre = head;
        now = head;
        
        if(nth.next==null)
            return head;
        else{
            while(nth.next!=null){
                nth = nth.next;
                pre = now;
                now = now.next;
            }
            
            pre.next = null;
            nth.next = head;
            return now;
        }
    }
}
