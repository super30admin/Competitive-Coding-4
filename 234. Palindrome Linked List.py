#Time Complexity:O(n)
#Space Complexity:O(1)
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
        slow=head
        fast=head
        while(fast.next!=None and fast.next.next!=None):
            slow=slow.next
            fast=fast.next.next
        temp=slow.next
        slow.next=None
        temp=self.reverse(temp)
        while(head!=None and temp!=None):
            if head.val!=temp.val:
                return False
            head=head.next
            temp=temp.next
        return True


    def reverse(self,node):
        prev=None
        curr=node
        while curr:
            next=curr.next
            curr.next=prev
            prev=curr
            curr=next
        return prev