/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    _, ans := postOrderDfs(root)
    return ans
}

func postOrderDfs(root *TreeNode) (int, bool) {
    // base
    if root == nil {
        return 0, true
    }
    
    
    // logic
    lh, lBalanced := postOrderDfs(root.Left)
    if !lBalanced {
        return -1, false
    }
    rh, rBalanced := postOrderDfs(root.Right)
    if !rBalanced {
        return -1, false
    }
    
    diff := abs(lh-rh)
    if diff > 1 {
        return -1, false
    }
    return int(math.Max(float64(lh), float64(rh)))+1, true
    
}

func abs(n int) int {
    if n < 0 {
        return n * -1
    }
    return n
}
