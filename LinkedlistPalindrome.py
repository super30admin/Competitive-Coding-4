   ----------------------palindrome linkedList--------------------------------------   
# Time Complexity : O(N) N is the nodes in the second LL
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can achieve solution in 3 steps. First need to find the middle pointer using slow and fast pointer.
# Then reverse the LL from the slow.next to end 
# Then compare the LL from the head pointer and tail pointer from the end.



class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or head.next == None:
            return True
        
        slow = head
        fast = head
        while fast.next!= None and fast.next.next!=None:
            slow = slow.next
            fast = fast.next.next
        
        def reverse(curr):
            prev = None
            slow = curr
            fast = curr.next
            while fast != None:
                slow.next = prev
                prev = slow
                slow = fast
                fast = fast.next
            slow.next = prev
            return slow
            
        tail = reverse(slow.next)
        slow.next = None
        
        h = head
        t = tail
        while t !=None:
            if h.val == t.val:
                h = h.next
                t = t.next
            else:
                return False
        return True