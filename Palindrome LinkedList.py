# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head==None:
            return True
   
        slow = head
        fast = head.next
        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            
        head2 = slow.next
        slow.next = None
        
        prev = None
        cur = head2
        next = None
        
        while cur:
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        head2 = prev

        while head and head2:
            print(head2.val)
            print(head.val)
            if head2.val != head.val:
                return False
            head2 = head2.next
            head = head.next
        
        return True
        
        