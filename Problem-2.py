#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if(head==None):
            return True
        
        #mid
        slow=head
        fast=head
        
        while(fast.next!=None and fast.next.next!=None):
            slow=slow.next
            fast=fast.next.next
            
        curr=slow.next
        strt=head
        
        prev=None
        #Reverse
        while(curr!=None):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        