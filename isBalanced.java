/* Given a binary tree, determine if it is height-balanced.

  For this problem, a height-balanced binary tree is defined as a binary tree, 
  in which the depth of the two subtrees of every node never differ by more than 1. */

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
    private int height(TreeNode node){
        if(node==null)
            return 0;
        else{ 
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            if(leftHeight==-1 || rightHeight==-1)
                return -1;
            else{
                if(Math.abs(leftHeight-rightHeight)>1)
                    return -1;
                else
                    return (Math.max(leftHeight, rightHeight)+1);
            }
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        int flag = height(root);
        
        if(flag==-1)
            return false;
        else
            return true;
    }
}
