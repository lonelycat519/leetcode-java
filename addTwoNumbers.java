/* You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8 */

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)    return l2;
        if(l2==null)    return l1;

        ListNode head = new ListNode(0);
        ListNode now = head;
        ListNode now1 = l1;
        ListNode now2 = l2;
        
        while(now1!=null&now2!=null){
            now.val += now1.val+now2.val;
            if(now.val>=10){
                now.next = new ListNode(1);
                now.val %= 10;
            }   else{
                if(now1.next!=null|now2.next!=null)
                    now.next = new ListNode(0);
            }
            now= now.next;
            now1 = now1.next;
            now2 = now2.next;
        }
        
        ListNode left = null;
        if(now1!=null)  left = now1;
        else if(now2!=null) left = now2;
        
        while(left!=null){
            now.val += left.val;
            if(now.val>=10){
                now.next = new ListNode(1);
                now.val = now.val%10;
            }   else{
                if(left.next!=null)
                    now.next = new ListNode(0);
            }
            now = now.next;
            left = left.next;
        }
        
        return head;
    }
}


// Second Version
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1 == null || l2 == null) {        
            return (l1 == null) ? l2 : ((l2 == null) ? null : l2);
        }

        ListNode result = new ListNode(0);
        ListNode now = result;
        ListNode now1 = l1;
        ListNode now2 = l2;
        int temp = 0;
        
        while(now1!=null || now2!=null) {            
            if(now1!=null) {
                temp += now1.val;
                now1 = now1.next;
            }
            if(now2!=null) {
                temp += now2.val;
                now2 = now2.next;
            }
            
            now.next = new ListNode(0);
            now = now.next;
            if(temp >= 10) {
                now.val = temp - 10;
                temp = 1;
            } else {
                now.val = temp;
                temp = 0;
            }
        }
        if(temp != 0) {
            now.next = new ListNode(temp);    
        }
        
        return result.next;
    }
}
