#234. Palindrome Linked List
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # go to the mid and split the linkedlist and reverse 2nd part
        slow=head
        fast = head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next

        curr = slow.next
        slow.next = None
        prev = None

        # # reverse 2nd half
        while curr!=None:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        ptr = head
        
        while prev!=None and ptr!=None:
            if prev.val != ptr.val:
                return False
            prev=prev.next
            ptr=ptr.next
        return True
