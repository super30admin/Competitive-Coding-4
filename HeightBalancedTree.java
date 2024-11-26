//TimeComplexity=O(nlogn)
//Space Complexity=O(1)
public class HeightBalancedTree {

    private int height(TreeNode root,int count){
        if(root==null) return 0;

        int l=height(root.left,count+1);
        int R=height(root.right,count+1);

        return 1+Math.max(l,R);
    }

    public boolean isBalanced(TreeNode root) {

        if(root==null) return true;

        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);

        int hL=height(root.left,0);
        int hR=height(root.right,0);
        boolean flag=true;
        if(Math.abs(hL-hR)>1){
            flag=false;
        }

        return left && right && flag;
    }
}
