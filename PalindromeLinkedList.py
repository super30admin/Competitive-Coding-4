#Time complexity: O(n)
#Space complexity: O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head) -> bool:
        if head.next==None:
            return True
        slow,fast=head,head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        prev=self.reverse(slow)
        curr=head
        while prev:
            if prev.val!=curr.val:
                return False
            prev=prev.next
            curr=curr.next
        return True

    def reverse(self,slow):
        prev=None
        curr=slow
        while curr:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        return prev        
        