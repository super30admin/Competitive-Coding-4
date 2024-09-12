// Time Complexity : nlog(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

   func isBalanced(_ root: TreeNode?) -> Bool {
        guard let root = root else {return true}
        var left = height(root.left)
        var right = height(root.right)
        if abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right)  {
            return true
        }
        return false
    }
    func height(_ node: TreeNode?) -> Int {
        if node == nil {
            return -1
        }
        var h = max(height(node?.left),height(node?.right)) + 1
        return h
    }
