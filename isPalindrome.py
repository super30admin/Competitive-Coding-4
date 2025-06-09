# // Time Complexity :O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# use slow fast pointer to find middle , then reverse second half then comapre values




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow=head
        temp=head
        fast=head
        while(fast.next is not None and fast.next.next is not None):
            slow,fast=slow.next, fast.next.next
        head2=slow

        #rever
        curr=head2
        prev =None
        while(curr):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        #here prev will be new head
        while(head is not None):
            if head.val!=prev.val:return False
            head=head.next
            prev=prev.next
        return True



        
