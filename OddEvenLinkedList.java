

public class OddEvenLinkedList {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	//TC - o(n)
    //SC - o(1)
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode fastHead = fast;
        
        //odd or even nums of node 
        //so check both 
        while(fast != null && fast.next != null){
            //assign next pointer of slow to next odd num
            slow.next = slow.next.next;
            //fast to next even no of node
            fast.next = fast.next.next;
            //for next iteration move slow to slow.next 
            //and fast to fast.next
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = fastHead;
        
        return head;
    }

}
