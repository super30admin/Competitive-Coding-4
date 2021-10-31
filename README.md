# Competitive-Coding-4
# Balanced Binary Tree

# Time Complexity=O(n*height of the tree)
# Space Complexity=O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height(node):
            if not node:
                return -1
            return 1+max(height(node.left),height(node.right))
        def BBT(root):
            if not root:
                return True
            if abs(height(root.left)-height(root.right))>1:
                return False
            else:
                return BBT(root.left) and BBT(root.right)
        return BBT(root)
# Given Linked List Palindrome or not

# Time Complexity=O(n)
# Space Complexity=O(1)

# This approach is analogus to the reorder of the given linked list

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        def reverseLL(root):
            if not root or not root.next:
                return root
            ptr=reverseLL(root.next)
            root.next.next=root
            root.next=None
            return ptr
        mid=slow.next
        slow.next=None
        head2=reverseLL(mid)
        while head2:
            if head.val!=head2.val:
                return False
            head=head.next
            head2=head2.next
        return True