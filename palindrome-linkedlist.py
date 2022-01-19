# TC: O(N)
# SC: O(1)
#  LC: YES

from typing import List, Optional


class ListNode(object):
    def __init__(self, data: int) -> None:
        self.data = data
        self.next = None
        
class LinkedList(object):
    def __init__(self) -> None:
        self.head = None
        self.counter = 0
    
    def append(self, data: int) -> None:
        newNode = ListNode(data)
        if self.head == None:
            self.head = newNode
            self.counter += 1
        else:
            current = self.head
            while(current.next != None):
                current = current.next
            current.next = newNode
            self.counter += 1
    
    def length(self) -> None:
        return self.counter
    
    def createLinkedList(self, data: List[int]) -> ListNode:
        for item in data:
            self.append(item)
        return self.head
            
    def readList(self, head: ListNode[int]) -> List[int]:
        current = head
        result = []
        while(current.next != None):
            result.append(current.data)
            current = current.next
        return result

class Solution: 
     def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummyNode = ListNode(-1)
        dummyNode.next = head
        counter = 0
        fast, slow = dummyNode, dummyNode
        while(counter < n):
            fast = fast.next
            counter += 1
        while(fast.next != None):
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next
        return dummyNode.next