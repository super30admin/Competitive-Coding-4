public class IsBalancedBinaryTree {
    /**
     * Definition for a binary tree node.*/
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    //Time Complexity : O(n(logn))
//space Complexity : O(n) >> recursive stack
//Leetcode: yes
    class Solution {
        public boolean isBalanced(TreeNode root) {

            if (root == null) {
                return true;
            }
            //get height at each node..call its left and right child to get height. After getting teh heigh for that node..got to its children and do the same step
            return (Math.abs(getHeight(root.left) - getHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right));
        }

        public int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

//Time Complexity : O(n)
//space Complexity : O(n) >> recursive stack
//Leetcode: yes
//Solution 2 Bottom UP
    class Solution2 {
        public boolean isBalanced(TreeNode root) {

            if (root == null) {
                return true;
            }

            int val = getHeight(root);
            return (val != -1);
        }

        public int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //keep going down and get height..if there is an unbalanced node return -1 otherwise return the actual height of the tree.
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);
            if (Math.abs(lh - rh) > 1) return -1;
            if (lh == -1 || rh == -1 ) return -1;

            return 1 + Math.max(lh, rh);


        }
    }
}
