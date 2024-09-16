import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Iterative search
    // Time Complexity : O(p) where p is total number of p element in treeNode
    // Space Complexity : O(p)

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();

        que1.add(p);
        que2.add(q);
        while (!que1.isEmpty()) {
            TreeNode root1 = que1.poll();
            TreeNode root2 = que2.poll();

            if (!check(root1, root2)) return false;
            if (root1 != null) {
                // in Java nulls are not allowed in Deque
                if (!check(root1.left, root2.left)) return false;
                if (root1.left != null) {
                    que1.add(root1.left);
                    que2.add(root2.left);
                }
                if (!check(root1.right, root2.right)) return false;
                if (root2.right != null) {
                    que1.add(root1.right);
                    que2.add(root2.right);
                }
            }
        }

        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }


    //DFS
    // Time Complexity : O(p) where p is total number of p element in treeNode
    // Space Complexity : O(p)

    boolean isSame;
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        isSame = true;
        helper(p, q);
        return isSame;
    }

    private void helper(TreeNode p, TreeNode q) {
        //base case
        if (p == null && q == null) {
            return;
        }
        if (p == null || q == null) {
            isSame = false;
            return;
        }
        //logic
        if (p.val != q.val) {
            isSame = false;
        }

        if (isSame) {
            helper(p.left, q.left);
            helper(p.right, q.right);
        }
    }
}

