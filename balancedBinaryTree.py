#TimeComplexity:O(N) since we are iterating for each element in worst case 
#SpaceComplexity: O(maxDepth) for stack
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    answer=True
    def height(self,root):
        if root==None or (not self.answer):#if we get false in middle then it wont check the right part as it returns 0.
            return 0
        l=self.height(root.left)
        r=self.height(root.right)
        if abs(l-r)>1:
            self.answer=False
        return max(l,r)+1
    def isBalanced(self, root: TreeNode) -> bool:
        self.height(root)    
        return self.answer

                    