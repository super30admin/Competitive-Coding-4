// In this problem we need find out if the given tree is balanced or not. To solve this problem, we can use the height of the tree. 
//We will calculate the height of the tree and if the height of left tree and right tree differ by more than 1 then we will return false otherwise we will return true. 
// Time complexity: O(n) where n is the number of nodes in the tree.
// Space complexity: O(h) where h is the height of the tree.
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        return height(root) != -1
    }

    private fun height(root: TreeNode?): Int {
        root ?: return 0
        val lheight = height(root.left)
        val rheight = height(root.right)
        val diff = Math.abs(lheight - rheight)

        if(lheight == -1 || rheight == -1 || Math.abs(lheight - rheight) > 1 ) return -1
        else return 1 + maxOf(lheight, rheight) 
    }
}