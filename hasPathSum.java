/* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. */

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
    private boolean getSum(TreeNode root, int sum, int total) {
        if(root.left==null && root.right==null)
            return (total+root.val==sum);
        else {
            boolean left = (root.left!=null && getSum(root.left, sum, total+root.val));
            boolean right = (root.right!=null && getSum(root.right, sum, total+root.val));
            return (left || right);
        }
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return false;
            
        boolean result = getSum(root, sum, 0);
        return result;
    }
}
