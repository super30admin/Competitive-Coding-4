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
    # Method 1) on O(n^2) time
    # def isBalanced(self, root) :
    #     if not root:
    #         return True 
    #     return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left) - self.height(root.right)) <= 1 
    
    # def height(self,root):
    #     if not root:
    #         return 0 
    #     return max(self.height(root.left),self.height(root.right)) + 1 
    
    # Method 2) O(n) time with a global boolean to store the result 
        result = True 
        def isBalanced(self, root) :
            self.__helper(root)
            return self.result

        def __helper(self,root):
            if not root:
                return 0 
            l = self.__helper(root.left) 
            r = self.__helper(root.right)
            if abs(l-r) > 1 :
                self.result = False 
            return 1 + max(l,r)

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