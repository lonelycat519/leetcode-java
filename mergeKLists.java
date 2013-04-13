/* Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. */

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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists == null || lists.size() == 0)
            return null;
        
        ListNode resultList = lists.get(0);
        
        for(int i=1; i<lists.size(); i++) {
            if(lists.get(i) != null) {
                resultList = Insert(resultList,  lists.get(i));
            }
        }
        
        return resultList;
    }
    
    private ListNode Insert(ListNode resultList, ListNode list) {
        ListNode now = resultList;
        
        if(resultList == null) {
            resultList = list;
            return resultList;
        }
        
        while(now!=null && list!=null) {
            if(now.val > list.val) {
                int temp = now.val;
                ListNode next = now.next;
                now.next = new ListNode(now.val);
                now.val = list.val;                
                now.next.next = next;
                list = list.next;
            } else {
                if(now.next == null) {
                    now.next  = list;
                    return resultList;
                }
                now = now.next;
            }
        }
        
        return resultList;
    }
}
