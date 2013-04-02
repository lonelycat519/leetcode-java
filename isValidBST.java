/* Given a binary tree, determine if it is a valid binary search tree (BST).

  Assume a BST is defined as follows:
  The left subtree of a node contains only nodes with keys less than the node's key.
  The right subtree of a node contains only nodes with keys greater than the node's key.
  Both the left and right subtrees must also be binary search trees. */

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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null ) 
            return true;
        else {
            if (root.val<=min || root.val>=max)
                return false;
        
            return (isBST(root.left, min, root.val) && isBST(root.right, root.val, max));
        }
    }
}
