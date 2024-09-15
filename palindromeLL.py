# Time Complexity : O(1) 
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        ispal = True
        slow = head
        fast = head

        #find middle
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        
        #reverse LL from mid+1 element
        fast = self.reorder(slow.next)

        #compare first and second half of LL
        slow.next = None
        slow = head
        while(fast!=None):
            if fast.val!=slow.val:
                ispal = False
                break
            fast = fast.next
            slow = slow.next
        return ispal



    def reorder(self,head):
        if head==None or head.next == None:
            return head
        reverse = self.reorder(head.next)
        head.next.next = head
        head.next = None
        return reverse


