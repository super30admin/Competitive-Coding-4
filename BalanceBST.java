/*
 * Time Complexity -  O(2 * N) ~ O(N) 
 * Space Complexity-  O(N)
 */
class Solution {
    
    public TreeNode balanceBST(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null))
            return root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> list = new ArrayList<>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return getBalancedBST(list, 0, list.size() - 1);
    }
    
    public TreeNode getBalancedBST(List<Integer> list, int start, int end){   
        if(start < 0 || end >= list.size() || start > end)
            return null;    
        int rootPos = (end - start) / 2 + start;
        TreeNode cur = new TreeNode(list.get(rootPos));
        cur.left = getBalancedBST(list, start, rootPos - 1);
        cur.right = getBalancedBST(list, rootPos + 1, end);    
        return cur;
    }  
}
