"""
Runtime Complexity:
O(n) - we use two pointers here to find the mid of the linked list. Then we separate the first half by unchaining it and we traverse and
reverse the second half. Then we iterate over both half and compare. If they are not equal we return false else true.
Space Complexity:
O(1) - no extra data structure was used. Therefore space is constant.
Yes, the code worked on leetcode.
Issues whike coding- No.
"""
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        #find the mid point
        while(fast.next!=None and fast.next.next!=None):
            slow = slow.next
            fast = fast.next.next
        mid = slow
        prev = None
        curr = mid.next
        mid.next = None
        
        
        #Reverse the linked list
        while(curr!=None):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        second_half = prev
        first_half = head
        
        while first_half and second_half:
            if first_half.val!=second_half.val:
                return False
            first_half = first_half.next
            second_half = second_half.next
        return True
            
        
        