// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
    
    let dfs = function(root) {
        if(root === null) return [true, 0];

        let left = dfs(root.left);
        let right = dfs(root.right);
        //check if the first value in the return is true, if its false no poiont checking height
        let balanced = left[0] && right[0] && Math.abs(left[1] - right[1]) <= 1;
        //adding 1 to height for root, and then max height between left and right subtree
        return [balanced, 1 + Math.max(left[1], right[1])];
    }

    //dfs(root) will return a boolean so we will assign it to the first index of the return we set up 
    return dfs(root)[0];
};