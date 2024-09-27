# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Problem 1: Palindrome linked-List
#Time Complexity: O(n)
#Space Complexity O(1)
class Solution:
    def reverse(self,head):
        if not head:
            return head
        res=None
        pres=head
        while pres:
            temp=pres.next
            pres.next=res
            res=pres
            pres=temp
        return res


    def isPalindrome(self, head: ListNode) -> bool:
        #edge case
        if not head or not head.next:
            return True

        #find mid
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next

        #detach
        fast=slow.next
        slow.next=None

        fast=self.reverse(fast)

        slow=head
        while fast and slow:
            if slow.val!=fast.val:
                return False
            fast=fast.next
            slow=slow.next
        return True

## interview tips modularize the code
## fill in the comments first (pseudo-code) for the steps then fill it (if lengthy)
