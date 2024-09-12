// Height Balanced Tree
// https://leetcode.com/problems/balanced-binary-tree/

// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Top down approach


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
var height = (root) => {
    if (root === null)
        return 0;
    // Find left height and right heght
    let leftheight = 1 + height(root.left);
    let rightheight = 1 + height(root.right);
    // Height of the root will be max of the two
    return Math.max(leftheight, rightheight);
}
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function (root) {
    if (root === null)
        return true;
    // Find height of left root and right root
    let leftheight = height(root.left);
    let rightheight = height(root.right);
    // Difference in height should be less than or equal to 1
    // This should hold true for each node
    return (Math.abs(leftheight - rightheight) <= 1 && isBalanced(root.left) && isBalanced(root.right));
};