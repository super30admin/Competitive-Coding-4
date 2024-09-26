# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#O(N for both)
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        #1)find mid
        slow=head
        fast=head
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
        #2)reverse 2nd half
        def reverse(self,head):
            cur=head
            prev=None
            while cur:
                temp=cur.next
                cur.next=prev
                prev=cur
                cur=temp
            return (prev)
        revhalf=reverse(self,slow)
        #3)traverse both halfs simultaneously till reversed list ends and if values mismatch>false
        while revhalf:
            if revhalf.val!=head.val:
                return False
            revhalf=revhalf.next
            head=head.next
        return True