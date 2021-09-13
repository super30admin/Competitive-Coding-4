# // Time Complexity :O(n) 
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach







# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow=head
        if not head.next:
            return True
        fast=head.next
        while(fast and fast.next):
            slow=slow.next
            fast=fast.next.next
        # print(slow.val)
        # print(slow.next.val)
        
        prev=None
        curr=slow.next
        if curr.next:    
            last=curr.next
            while(last):
                print("a")
                print(curr.val)
                curr.next=prev
                prev=curr
                curr=last
                last=curr.next
​
            curr.next=prev
​
​
            slow.next=None
            first=head
        else:
            first=head
            
        
        
        print(curr.val)
        print(first.val)
        while(first and curr):
            print(first.val)
            print(curr.val)
            if(first.val is not curr.val):
                return False
            first=first.next
            curr=curr.next
        return True