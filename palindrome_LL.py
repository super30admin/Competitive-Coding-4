# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Divide the LL via mid. 
2. Take the second half of the LL
3. Reverse it using 3 pointers
4. Again use two pointers to move across the two LL, and comapre each node. If unequal return False

'''


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        if head is None:
            return True
        
        slow = head
        fast = head
        
        while fast.next and fast.next.next:
            
            slow = slow.next
            fast = fast.next.next
            
        point1 = head
        point2 = slow.next
        slow.next = None
        
        print(point1.val)
            
        #reverse
        
        prev = None      
        while point2:
            
            forw = point2.next
            point2.next = prev
            prev = point2
            point2 = forw
            # prev.next = None
            
        # print (point2.val)
        
        point2 = prev
        
        # print (point1.val, point2.val)
        while point1 and point2:
            
            if point1.val == point2.val:
                point1 = point1.next
                point2 = point2.next
            else:
                return False
            
        return True