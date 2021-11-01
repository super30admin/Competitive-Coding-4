
#time complexity O(nlogn), space O(1)
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
      #function to find the height of both sides
        def helper(root):
            if not root:
                return 0
            l =helper(root.left)
            r =helper(root.right)
            if l==-1 or r==-1 or abs(l-r)>1:
                return -1
            return 1+max(l,r)
        return helper(root)!=-1
