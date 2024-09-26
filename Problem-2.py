# Pallindrom Linked List

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes, with Runtime: 76 ms and Memory Usage: 24.4 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
Using Array and  two pointer approach, The values are copied into array and
to heck for pallindrome the comparison is done between array and its reverse 
to be true.
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        arr=[] # Initializing an empty array
        curr_node=head # Pointer poiniting to head
        while curr_node is not None:
            arr.append(curr_node.val) 
            curr_node=curr_node.next
        return (arr==arr[::-1])