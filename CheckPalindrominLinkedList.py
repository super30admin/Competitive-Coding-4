#Time Complexity : O(n) - Finding mid/ Comparing Values are all O(n) max
#Space Complexity : O(1) - Not storing anything apart from a few pointers so no extra space

def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = slow.next
        
        #finding mid element
        
        while(fast != None and fast.next != None):
            slow = slow.next 
            fast = fast.next.next
    
        #Setting a pointer to the second part of linked List
        head2 = slow.next
        
        #Dividing the original linked list in 2 parts
        slow.next = None
        
        #Reversing the second linked list half whose head is head2
        prev = None
        curr = head2
        
        #Reversing
        while(curr != None):
            nextt = curr.next
            curr.next = prev
            prev = curr
            curr = nextt
            
        head2 = prev
        
        while(head != None and head2 != None):
            if head.val != head2.val:
                return False
            else:
                head = head.next
                head2 = head2.next
            
        return True
        