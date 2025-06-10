# TC: O(n)
# SC: O(h)
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        flag=True

        def helper(root ,h):
            nonlocal flag
            #base
            if not root or not flag:
                return h-1
            #logic

            left_height=helper(root.left ,h+1)
            right_height=helper(root.right, h+1)

            print(root.val, left_height, right_height)
            if abs(left_height - right_height) >1:
                flag=False
            

            return max(left_height, right_height)
        
        helper(root,0)
        
        return flag