package cc_4;



import java.util.ArrayList;
import java.util.List;

public class balance_BST {
    //TC: O(n)
    //SC: O(n)
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        return build(0, list.size()-1);
    }
    private void dfs(TreeNode root){
        //base
        if (root==null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    //Building a tree from the above list
    TreeNode build(int left, int right){
        //base
        if (right<left) return null;
        int mid = (left+right)/2;
        TreeNode result = new TreeNode(list.get(mid));
        result.left = build(left, mid-1);
        result.right = build( mid+1, right);
        return result;
    }

}
