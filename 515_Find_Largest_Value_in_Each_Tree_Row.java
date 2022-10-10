
//Optimized approach , no B-F
//Level order traversal
//Take a queue, keep adding nodes, and check the max at each level
//TC- O(n) - processing all nodes
//sc -O(n) - queue

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
    
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result =new ArrayList<>();
        //base case
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            //max from the queue, we'll also check nodes
            //[3,2, 5,3]
            for(int i =0; i< size; i++)
            {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                
                //child nodes
                if(curr.left!= null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }
            result.add(max);
            max = Integer.MIN_VALUE; //reset the max;
        }
       return result;
    }
}


// Approach -2 
//using DFS, we can have a recursive stack with O(h) - but that's the avg case scenario, 
//in the worst case, stack will consume O(n)
//Tc- O(n)
//sc -O(h) - avg, worst - height = nodes O(n)
