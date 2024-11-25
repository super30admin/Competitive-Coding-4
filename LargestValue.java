public class LargestValue {
    //dfs solution 
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root){
        if(root == null) return new ArrayList<>();
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode node, int depth){
        //base
        if(node == null) return;

        //logic
        if(result.size() == depth) result.add(node.val);
        else result.set(depth, Math.max(node.val, result.get(depth)));

        //recurse
       dfs(node.left, depth+1);
       dfs(node.right, depth+1);
    }


    //bfs
    // public List<Integer> largestValues(TreeNode root) {
    //     if(root == null) return new ArrayList<>();
    //     List<Integer> result = new ArrayList<>();
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         int currMax = Integer.MIN_VALUE;
    //         for(int i = 0; i < size; i++){
    //             TreeNode curr = q.poll();
    //             currMax = Math.max(currMax, curr.val);
    //             if(curr.left != null) q.offer(curr.left);
    //             if(curr.right != null) q.offer(curr.right);
    //         }
    //         result.add(currMax);
    //     }
    //     return result;
    // }
}
