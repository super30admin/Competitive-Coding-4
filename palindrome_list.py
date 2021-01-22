# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        #base case
        if not head:
            return True
        
        # middle node
        slow = head
        fast = head.next
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        # headB -> 2  
        headB = slow.next
        slow.next = None
         
        # reverse
        fast = self.reverse(headB)
        
        # Check val of head and headB
        while head and fast:
            if head.val != fast.val:
                return False
            else:
                head = head.next
                fast = fast.next
        return True
        
    def reverse(self, head):
        prev = None
        curr = head
        fast = ListNode(-1)

        while curr != None:
            fast = curr.next
            curr.next = prev
            prev = curr
            curr = fast
            #fast = fast.next
            
        #curr.next = prev
        head = prev
        return head
