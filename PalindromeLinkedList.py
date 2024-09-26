# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    '''Time Complexity: O(n)
    Space Complexity: O(1)'''
    def __reverseList(self, head):
        prev=None
        curr=head
        fast=head.next
        
        while fast is not None:
            curr.next=prev
            prev=curr
            curr=fast
            fast=fast.next
            
        curr.next=prev
        return curr
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or head.next is None:
            return True
        #Finding the mid
        slow=head
        fast=head
        while fast.next is not None and fast.next.next is not None:
            slow=slow.next
            fast=fast.next.next
        
        #Reverse the 2nd half of the list
        fast= self.__reverseList(slow.next)
        #reset
        slow.next=None
        slow=head
        
        while fast is not None:
            if slow.val!=fast.val:
                return False
            slow=slow.next
            fast=fast.next
        return True
        
