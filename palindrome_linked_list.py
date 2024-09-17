# // Time Complexity : O(n) where n is the number of nodes in the given list
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        prev = None
        cur = slow
        follow = cur.next
        
        while follow:
            cur.next = prev
            prev = cur
            cur = follow
            follow = follow.next
        cur.next = prev
        
        pt1 = head
        pt2 = cur
        while pt1 and pt2:
            if pt1.val != pt2.val: return False
            pt1 = pt1.next
            pt2 = pt2.next
        return True
            