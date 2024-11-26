
"""
Time Complexity: O(N)
Space Complexity: O(N)
Accepted.
"""
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        """
        With O(N) space
        """
        arr, cur = [], head
        while cur:
            arr.append(cur.val)
            cur = cur.next
        return arr == arr[::-1] # if original and reverse is same it's palindrome
