# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """Find middle element, reverse the second half of list
    check if both first and second half are equal
    Time complexity-O(n)
    Space Complexity-O(1)"""
    def isPalindrome(self, head: ListNode) -> bool:
        if (not head or not head.next) or (head.val==head.next.val and not head.next.next):
            return True
        if head.val!=head.next.val and not head.next.next:
            return False
        ll=head
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        fast=self.reverse(slow.next)
        slow.next=None
        slow=head
        while fast:
            if slow.val==fast.val:
                fast=fast.next
                slow=slow.next
            else:
                return False
        return True 
    def reverse(self, head):
        prev=None
        slow=head
        fast=head.next
        while fast:
            slow.next=prev
            prev=slow
            slow=fast
            fast=fast.next
        slow.next=prev
        return slow

        