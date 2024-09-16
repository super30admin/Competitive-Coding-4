# Time Complexity : O(n)
# Space Complexity : O(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head == None:
            return None
    
        tempStack = []
        temp = head
        while temp:
            tempStack.append(temp.val)
            temp = temp.next
			
        while head:
            if head.val != tempStack.pop():
                return False
            head = head.next
     
        return True