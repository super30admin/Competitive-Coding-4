# T.C = O(n) S.C = O(1)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):

    def reverse(self,head2):
        prev = None
        curr = head2

        while(curr is not None):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        if head is None:
            return True
            
        slow = head
        fast = head

        while(fast.next is not None and fast.next.next is not None):
            slow = slow.next
            fast = fast.next.next

        head1 = head
        head2 = slow.next
        slow.next = None

        head2 = self.reverse(head2)

        p1 = head1
        p2 = head2

        while p2 is not None:
            if p1.val != p2.val:
                return False

            p1=p1.next
            p2=p2.next

        return True
        
        
        