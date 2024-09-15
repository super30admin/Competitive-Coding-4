# Time Complexity : O(n) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the midnode and reverse the first half and check if both are same.

class Solution:
    def reverse_list(self, node):
        rev_list = None
        cur_node = node
        while cur_node:
            next_node = cur_node.next
            cur_node.next = rev_list
            rev_list = cur_node
            cur_node = next_node
        return rev_list
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        temp=head
        n=0
        while(temp!=None):
            temp=temp.next
            n+=1
        if(n==1):
            return True
        
        mid=(n+1)//2
        
        print(mid)
        prev=None
        temp=head
        i=0
        print(head.val)
        while i < mid:
            i += 1
            head = head.next
        sectemp=self.reverse_list(head)
        
        while(sectemp):
            if(temp.val != sectemp.val):
                return False
            temp=temp.next
            sectemp=sectemp.next
            
        return True