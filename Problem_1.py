# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def recur(root):
            if not root:
                return [0, True]
            
            ldepth, lstat = recur(root.left)
            rdepth, rstat = recur(root.right)
            
            currStat = False
            if lstat and rstat and abs(ldepth - rdepth) <= 1:
                currStat = True
            currDepth = max(ldepth, rdepth) + 1 
            return [currDepth, currStat]
        
        
        _, status = recur(root)
        return status