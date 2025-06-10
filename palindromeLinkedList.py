# TC: O(n)
# SC: O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        
        
        curr=slow.next
        prev=None
        slow.next=None

        while curr:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        
        first=head
        second=prev

        while second:
            if first.val != second.val:
                return False
            first=first.next
            second=second.next
        
        return True