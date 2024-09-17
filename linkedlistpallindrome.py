# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

"""
https://leetcode.com/problems/palindrome-linked-list/solution/
TC: O(2n)
sc:On
"""
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        """We will copy the linked list to an array list and check if it array is pallindrome or not"""
        copylist = []
        currentNode = head
        while currentNode is not None:
            copylist.append(currentNode.val)
            currentNode = currentNode.next
        return copylist == copylist[::-1]
