/* Given an array where elements are sorted in ascending order, convert it to a height balanced BST. */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0)
            return null;
        else
            return makeBST(num, 0, num.length-1);
    }
    
    private TreeNode makeBST(int[] num, int low, int high) {
        if(low>high)
            return null;
        
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = makeBST(num, low, mid-1);
        root.right = makeBST(num, mid+1, high);
        return root;
    }
}
