#Time Complexity O(N^2)
#Space Complexity O(N) call stack
#It successfully runs on leetcode

#Approach: For each node finding height of left subtree and right subtre and checking weather their level difference is more than one or not
# if any one od node is returning False we will return False
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
        return self.helper(root)
    
    #storing height and comparing
    def helper(self,root):
        if not root: return True
        l = self.checkheight(root.left,1)
        r = self.checkheight(root.right,1)
        if abs(l-r)>1: 
            return False
        return self.helper(root.left) and self.helper(root.right)

    #checking height of tree(similar liek sum to leaf)
    def checkheight(self,root,count):
        if not root: return 0
        if not root.left and not root.right:
            return count
        return max(self.checkheight(root.left,count+1), self.checkheight(root.right,count+1))

#Time Complexity O(N)
#Space Complexity O(N) Call stack
#It successfully runs on leetcode

#Approach: For each node, finding depth, we will rather start from depth first and will add level of height to above level
# and check wether they are balanced or not at same time, if any of prev left or right is not balance we will directly stop the recursion and return False
# otherwise for a balanced one we wil return tru

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
        return self.helper(root)[0]
    
    def helper(self,root):
        if not root: return [True,0]
        left = self.helper(root.left)
        right = self.helper(root.right)
        isbal= (left[0] and right[0] and abs(left[1]-right[1])<=1)
        return [isbal, 1 + max(left[1],right[1])]