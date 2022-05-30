// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    if(root===null)
       { return true; }
    return ishght(root)!=-1;
};

var ishght = function(root){
    if(root===null)
    {
        return 0;
    }
    var left = ishght(root.left);
    if(left===-1)
    {
        return -1;
    }
    var right = ishght(root.right);
    if(right===-1)
    {
        return -1;
    }
    if(left-right<-1 || left-right>1)
    {
        return -1;
    }
    return 1+Math.max(left,right);
    
}
