# problem 1 : 234. Palindrome Linked List : https://leetcode.com/problems/palindrome-linked-list/
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        mid = self._getMiddle(head)
        second = self._reverse(mid.next)
        while head and second:
            if head.val != second.val:
                return False
            head = head.next
            second = second.next
        
        return True
    
    def _getMiddle(self, node: ListNode) -> ListNode:
        slow, fast = node, node
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def _reverse(self, node: ListNode) -> ListNode:
        prev = None
        curr = node
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        return prev
        
        
            
        


# problem 2 : 110. Balanced Binary Tree : https://leetcode.com/problems/balanced-binary-tree/
# Time Complexity : O(n)
# Space Complexity : O(n): 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        res = self.height(root)
        if res == -1:
            return False
        return True
    
    def height(self, node):
        #base condition
        if not node:
            return 0
        
        l_height = self.height(node.left)
        if l_height == -1:
            return -1
        l_height += 1
        r_height = self.height(node.right)
        if r_height == -1:
            return -1
        r_height += 1
        
        if abs(l_height - r_height) > 1:
            return -1
        
        return max(l_height,r_height)
            
        
        
        
        

