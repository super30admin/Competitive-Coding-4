// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
class Solution {
    boolean isvalid = true;
    public boolean isBalanced(TreeNode root) {
        postorder(root);
        return isvalid;
    }
    private int postorder(TreeNode root) {

        if ( root == null) { // base condition
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }          
        int lefth = postorder(root.left); 
        if (root.left != null) {
            lefth=lefth+1;
        }
        int righth = postorder(root.right); //  root = 3 1+2; = 3  3-1 2
        if (root.right != null) {
            righth = righth+1;
        }
        int diff = Math.abs(lefth - righth); //  2-1 = 1
        System.out.println(diff);
        if (diff > 1) {
            isvalid = false;
        }
        return Math.max(lefth, righth); // 3>1 3
    }
}

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
class Solution {
    boolean xfound=false;
    boolean yfound=false;        
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    public boolean isCousins(TreeNode root, int x, int y) {
        q.add(root);
        return findCousins(root, x, y);
    }

    private boolean findCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }else if (curr.right.val == x && curr.left.val == y) {
                        return false;
                    }
                }
                if (curr.val == x) {
                    xfound=true;
                }
                if (curr.val == y) {
                    yfound=true;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (xfound == true && yfound == true) {
                return true;
            } else if (xfound == true || yfound == true) {
                return false;
            }
        }
        return false;
    }
}
