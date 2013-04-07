/* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers. */

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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int sum) {
        if(root == null)
            return 0;
        
        int num = sum*10 + root.val;
        
        if(root.left == null && root.right == null)
            return num;
        
        else{
            return sumNumbers(root.left, num) + sumNumbers(root.right, num);
        }
    }
}
