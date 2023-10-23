# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : yes, faced trouble while comning up with edge cases for loops

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        def reverse(root):
            if not root or not root.next:
                return root
            curr=root
            prev=None
            while(curr.next is not None):
                
                temp=curr.next
                curr.next=prev
                prev=curr
                curr=temp
            curr.next=prev
            return curr
        slow=head
        fast=head
        # count=0
        while(fast.next is not None and fast.next.next is not None):
            slow=slow.next
            fast=fast.next.next
        mid=slow
        fast=reverse(mid)
        # print(fast)
        # slow.next=None
        slow=head
        flag=False
        
        while(slow is not None and fast is not None):
            if(slow.val!=fast.val ):
                return False
            slow=slow.next
            fast=fast.next
        return True

