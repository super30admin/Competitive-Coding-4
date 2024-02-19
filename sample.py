
# Palindrome linked list(https://leetcode.com/problems/palindrome-linked-list/)
// Time Complexity : o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach
# We can use this two pinter technique
# Copy all the linked list elements to an array
# Initially we can append all the linked list values to the list 
# check the array is polindrome

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        val = []
        current_node = head
        while current_node is not None:
            val.append(current_node.val)
            current_node = current_node.next
        return val == val[::-1]


#Height Balanced Binary Tree(https://leetcode.com/problems/balanced-binary-tree/description/)
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach
# We can do bottom up recursion.
# First we check the first child trees are balanced
# To calculate the height of a tree, all that remains is to compare the height of every node's children.
# If the subtrees are balanced, check if the current tree is balanced using their height

class Solution:
    # Return whether or not the tree at root is balanced while also returning
    # the tree's height
    def isBalancedHelper(self, root: TreeNode) -> (bool, int):
        # An empty tree is balanced 
        if not root:
            return True, -1
        
        # Check subtrees if they are balanced. 
        leftIsBalanced, leftHeight = self.isBalancedHelper(root.left)
        if not leftIsBalanced:
            return False, 0
        rightIsBalanced, rightHeight = self.isBalancedHelper(root.right)
        if not rightIsBalanced:
            return False, 0
        
        # If the subtrees are balanced, check if the current tree is balanced using their height
        return (abs(leftHeight - rightHeight) < 2), 1 + max(leftHeight, rightHeight)
        
    def isBalanced(self, root: TreeNode) -> bool:
        return self.isBalancedHelper(root)[0]



