# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def rev(self,root):
        prev=None
        curr=root
        while(curr!=None):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        return prev

    def isPalindrome(self, head):
        if(head.next==None):
            return True
        (fast,slow) = (head,head)
        while(fast.next!=None and fast.next.next!=None):
            fast=fast.next.next
            slow=slow.next

        head2=self.rev(slow.next)

        slow.next=None

        while(head2!=None):
            if(head.val !=head2.val):
                return False
            head=head.next
            head2=head2.next
        
        return True 