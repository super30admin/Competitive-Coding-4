# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

#Iterate through nodes in reverse using recursion
#Iterate forward at the same time using global variable and check for Palindrome

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head == None:
            return True
        self.low = head
        return self.helper(head)

    def helper(self, head):
        if head != None:
            if not self.helper(head.next):
                return False

            if head.val != self.low.val:
                return False

            self.low = self.low.next
        return True