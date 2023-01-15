/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    var dfs func(r *TreeNode) (int, bool)
    dfs = func(r *TreeNode) (int, bool) {
        // base
        if r == nil {return 0, true}
        
        // logic
        lHeight, lBalanced := dfs(r.Left)
        if !lBalanced {return 0,false}

        rHeight, rBalanced := dfs(r.Right)
        if !rBalanced {return 0,false}

        if abs(rHeight-lHeight) > 1 {return 0, false}

        return max(rHeight, lHeight)+1, true
    }
    _, ok := dfs(root)
    return ok
}

func max(x, y int) int {
    if x > y {return x}
    return y
}

func abs(x int) int {
    if x < 0 {return x * -1}
    return x
}
