# https://leetcode.com/problems/palindrome-linked-list/description/
# Time Complexity- O(n) Space Complexity- O(n)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: 'ListNode') -> bool:
        val = []
        curr = head
        while curr != None:
            val.append(curr.val)
            curr = curr.next
        
        slow = 0
        high = len(val) - 1
        while slow < high:

            if val[slow] != val[high]:
                return False
            slow += 1
            high -= 1
        return True

            