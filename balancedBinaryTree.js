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
    if(root == null) return true;
    let leftHeight = helper(root.left,0);
    let rightHeight = helper(root.right,0);
    if(Math.abs(leftHeight - rightHeight)>1) return false;
    return isBalanced(root.left) && isBalanced(root.right);
     
};

var helper = function(root,count){
    //base
    if(root == null) return count;
    //logic
    count = count+1;
    let leftcount = helper(root.left,count);
    let rightcount = helper(root.right,count);
    return Math.max(leftcount,rightcount);
    
};