// Time Complexity : O(n)//number of nodes
// Space Complexity :O(max depth)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:

        if not root:
            return True
        
        temp=self.recurr(root)
        return temp[1]
    
    
    def recurr(self, root):   
        if not root:      //if leaf node return height=1 and True
            return [1,True]
        else:
            temp1=self.recurr(root.left)    //if not leaf node calculate left height
            temp2=self.recurr(root.right)   //calculate right height
        
            
            if abs(temp1[0]-temp2[0])>1 or temp1[1]==False or temp2[1]==False:    // if difference between left height and right height is >0 =>tree is not height balanced hence return false
                return [max(temp1[0],temp2[0])+1,False]
            
            return [max(temp1[0],temp2[0])+1,True]  //if tree is height balanced return True along with the height at current node
                
