#Time Complexity: O(n)
#Space Complexity : O(1)

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        length = 0
        
        while(slow):
            previous = slow
            length +=1 
            slow = slow.next
        tail = previous
            
        if(length %2 == 0):
            n = (length//2)-1
        if(length %2 != 0):
            n = length //2
        mid = head
        for i in range(n):
            mid = mid.next
        curr = mid.next
        prev = mid
        while(curr):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        while(tail != mid and head != tail):
            if(head.val != tail.val):
                return False
            tail = tail.next
            head = head.next
        return True
