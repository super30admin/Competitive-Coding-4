# Time Complexity : O(n^2) time 
# Space Complexity : O(n^2) space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
    #1) for each subtree we need to check the height, so recurse on each and find height for that subtree again, so n^2 tc | sc 
    #2) recurse on left and right and see that check for the height condition 
        #2.1) each time height function is called, if root.left is present, height is 0+1 and same for root.right and +1 for the root.
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 

class Solution:
    def isBalanced(self, root) :
        if not root:
            return True 
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left) - self.height(root.right)) <= 1 
    
    def height(self,root):
        if not root:
            return 0 
        return max(self.height(root.left),self.height(root.right)) + 1 

if __name__ == "__main__":
    s = Solution()
    n = Node(1)
    n.left = Node(2)
    n.right = Node (2)
    n.left.left = Node(3)
    n.right.right = Node(3)
    n.left.left.left = Node(4)
    n.right.right.right = Node(4)    
    res = s.isBalanced(n)
    print(res)