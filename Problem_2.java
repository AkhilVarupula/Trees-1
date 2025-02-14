/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Time Complexity : O(n^2) 
// Space Complexity :O(n^2) 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0) return null;
        TreeNode root= new TreeNode(preorder[0]);
        int index=-1;
        for(int i=0;i<inorder.length;i++){
            if(root.val==inorder[i]){
                index=i;
                break;
            }
        }
        int[] preOrderLeft=Arrays.copyOfRange(preorder, 1,index+1);
        int[] preOrderRight=Arrays.copyOfRange(preorder,index+ 1,preorder.length);
        int[] inOrderLeft=Arrays.copyOfRange(inorder, 0, index);
        int[] inOrderRight=Arrays.copyOfRange(inorder, index+1, inorder.length);
        root.left=buildTree(preOrderLeft, inOrderLeft);
        root.right=buildTree(preOrderRight, inOrderRight);
        return root;

    }
}