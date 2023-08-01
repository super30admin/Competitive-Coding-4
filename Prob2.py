# Time complexity : O(n)
# Space complexity : O(1)

# Find mid, reverse the 2nd half and compare the 2 halves.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow=fast=head

        #get mid
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
        
        new_head=slow

        #reverse the 2nd half
        def reverse(head):
            #base
            if not head or not head.next:
                return head
                

            #logic
            rev=reverse(head.next)
            head.next.next=head
            head.next=None
            return rev
        
        rev_head=reverse(new_head)

        #compare the two
        first=head
        second=rev_head

        while first and second:
            if first.val==second.val:
                first=first.next
                second=second.next
            else:
                return False
        return True



