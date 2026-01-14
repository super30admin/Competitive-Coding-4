# Time: O(n^2)
# Space: O(h)

# At first we put the recursion on isBalanced to go on each node and then call the height funtion on each node
# Then in the height function we have a recursion to calculate the height of the tree from a particular node
# while returning from the isBalanced function we will return both left and right functional call as even if one on them is not balanced we should return False
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        if (abs(self.height(root.right) - self.height(root.left)) > 1):
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)
    def height(self,root):
        if root == None:
            return 0

        left = self.height(root.left)
        right = self.height(root.right)

        return (max(left,right) + 1)
    

# Time: O(n)
# Space: O(h)

# from the helper function when we come back from the recursive stack we just conditionally change the returns
# That is if the tree is balanced we return the height of the tree and if not we return -1
# If we have the difference > 1 and if both left and right subtree return -1 then in both of those cases we return -1
# Else we return the height of the tree which is max between left and right and add 1 to it

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return False if self.helper(root) == -1 else True
    def helper(self,root):
        if root == None:
            return 0

        left = self.helper(root.left)
        right = self.helper(root.right)

        if abs(left - right) > 1:
            return - 1
        elif left == -1 or right == -1:
            return - 1
        return max(left,right) + 1