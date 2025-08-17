// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We perform a DFS on the tree. For each node, we calculate the height of its left and right subtrees.  
// If at any point, the difference between left and right heights is greater than 1,  
// we mark the tree as unbalanced by returning -1.  
// Otherwise, we return the height of the current node = max(left, right) + 1.  
// If the DFS returns -1 for the root, the tree is not balanced, else it is balanced. 


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}




public class BalancedBinaryTree {
    public boolean solve(TreeNode root){
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftht = dfs(node.left);
        if(leftht == -1) {
            return -1;
        }
        int rightht = dfs(node.right);
        if(rightht == -1){
            return -1;
        }

        if(Math.abs(leftht - rightht) > 1){
            return -1;
        }

        return Math.max(leftht, rightht) + 1;


    }

    public static void main(String[]args){
        TreeNode root = new TreeNode(3, 
                            new TreeNode(9),
                            new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        BalancedBinaryTree ob = new BalancedBinaryTree();
        System.out.println(ob.solve(root));

    }

    
}
