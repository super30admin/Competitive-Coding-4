
"""
234. Palindrome Linked List
Easy
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 
Example 1:


Input: head = [1,2,2,1]
Output: true

Example 2:


Input: head = [1,2]
Output: false

 
Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

 
Follow up: Could you do it in O(n) time and O(1) space?
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(n) for recursive stack
    
    Explanation: The intuition is to use a recursive stack to store the values and pop them off
        While maintaining a walker pointer to traverse the list in the normal order.
        If the walker pointer and the popped value are not equal, then the list is not a palindrome.
        Think of it as a stack of values that are popped off in reverse order and compared to the list.
        Instead of a real stack, we use the recursive stack.
    """
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        walker = head
        flag = True
        def rec(head):
            nonlocal walker
            nonlocal flag
            if head is None or walker is None:
                return 
            rec(head.next) #Kind of DFS. recurse to the end of the list
            if not head.val == walker.val: # during recursive callbacks, measure the walker pointer against the popped value
                flag = False
                return False 
            walker = walker.next # increment the walker pointer
            return True
        rec(head)
        return flag

LeetCode(PROBLEM, Solution).check()
