///Balanced Binary Tree
//tc - O(n)
//sc - O(n) recursive stack

public class Problem1{
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        Problem1 p = new Problem1();
        System.out.println(p.isBalanced(root));

    }

    public boolean isBalanced(TreeNode root) {
        //recursive 
        
        if(root== null)
            return true;
        //recursive
        return (Math.abs((dfs(root.left)) - dfs(root.right))) < 2 && isBalanced(root.left)
            && isBalanced(root.right);
        
    }
    public int dfs(TreeNode root){
        if(root == null)
            return -1;
        return 1+ Math.max(dfs(root.left) , dfs(root.right));
        
    }
}