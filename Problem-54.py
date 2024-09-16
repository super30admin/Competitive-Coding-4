# Leet code- Palindrome linked list -234
# Time Complexity- O(N)
#space complexity -O(1)
# Approach - First we need to find the middle element and then we have to reverse the second half. If firts half values matches second half values then it is palindrome.


# Definition for singly-linked list.
 class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head ==None: return True
        
        fast=head.next
        slow=head
        while fast!=None and fast.next!=None:
            
            fast=fast.next.next
            slow=slow.next
        
        head2=slow.next
        slow.next=None
        prev=None
        curr=head2
        while curr!=None:
            next=curr.next
            curr.next=prev
            prev=curr
            curr=next
        head2=prev
        
        head1=head
        head2=head2
        while head1!=None and head2!=None:
            if head1.val!=head2.val:
                return False
            else:
                head1=head1.next
                head2=head2.next
        return True