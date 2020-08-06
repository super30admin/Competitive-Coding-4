# Leetcode 234. Palindrome Linked List

# Time Complexity :  O(n) where n is the number of nodes

# Space Complexity : O(n/2) where n is the number of nodes

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Traverse to the mid point using slow pointer at 1x speed and fast pointer at 2x unitl 
# fast points to last node. Reverse the second half of the list starting from element next to slow 
# pointer. And move slow to head of the first half. Move slow and fast pointer at 1x and compare the nodes
# at each pointer. If they are not same return false, else return true.

# Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverse(self,head):
        if head == None or head.next == None:
            return head
        last = self.reverse(head.next)
        head.next.next = head
        head.next = None
        return last
    
    def isPalindrome(self, head: ListNode) -> bool:
        if head == None or head.next == None:
            return True
        slow =head
        fast =head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        
        while fast and slow:
            if fast.val == slow.val:
                fast = fast.next
                slow = slow.next
            else:
                return False
        return True