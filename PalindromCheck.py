#Time Complexity : O(N)
#Space Complexity : O(1)
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
        def reverse(head):
            prev = None
            fast = head.next
            curr =head
            while(fast!=None):
                curr.next = prev
                prev = curr
                curr =fast
                fast = fast.next
            curr.next = prev
            return curr
        if head==None or head.next==None:
            return True

        slow = head
        fast = head
        while(fast.next != None and fast.next.next!=None):
            slow =slow.next
            fast = fast.next.next
        
        fast1 = reverse(slow.next)
        slow.next = None
        slow = head
        
        while(slow!=None and fast1!=None):
            if slow.val != fast1.val:
                return False
            
            slow = slow.next
            fast1 = fast1.next
        return True  