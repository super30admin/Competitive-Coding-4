# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """
     
        p1,p2=head,head
        #mid
        while(p2.next and p2.next.next): 
            p1=p1.next
            p2=p2.next.next
        
        #reverse
        prev=None
        curr=p1.next
        p1.next=None
        while(curr):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp

        p1=head
        p2=prev
        #compare
        while(p1 and p2):
            if p1.val!=p2.val:
                return False
            p1=p1.next
            p2=p2.next
        
        return True
            

        