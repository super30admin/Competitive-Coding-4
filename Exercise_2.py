#Time Complexity : O(N^2), N being nodes in the tree
#Space Complexity : O(N*logN), N being nodes in the tree
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Know the complexity isn't ideal. 

#Your code here along with comments explaining your approach in three sentences only
'''For each node, find the height of the left and right subtree. If difference of 
height is greater than 1, then return False, else True. 
'''
class Solution:
    #returns the max height of tree/subtree. 
    def helper_max(self, node, height):
        if node==None:
            return height
        else:
            left = self.helper_max(node.left, height+1)
            right = self.helper_max(node.right, height+1)
            return max(left, right)

    def helper(self, node, height):
        if node==None:
            return True
        else:
            #find max of each subtree
            left = self.helper_max(node.left, height+1)
            right = self.helper_max(node.right, height+1)
            #if diff is greater than 1, then return false. 
            current = True
            if abs(left-right)>1:
                current = False
                return False
            #else recurse. 
            if current==True:
                left = self.helper(node.left, height+1)
                right = self.helper(node.right, height+1)
                return left and right

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        else:
            return self.helper(root, 0)