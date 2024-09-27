#Time Complexity: O(n)
#Space Complexity: O(1)

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        length=0
        slow=head
        fast=head
        while fast!=None and fast.next!=None:
            slow=slow.next
            fast=fast.next.next
        prev=None
        while slow!=None:
            temp=slow.next
            slow.next=prev
            prev=slow
            slow=temp
        while prev:
            if head.val!=prev.val:
                return False
            head=head.next
            prev=prev.next
        return True
        
        
        