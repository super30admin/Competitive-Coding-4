import java.util.*;

public class PalindromeLinkedList {

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

	// TC - o(n)
	// SC -o(n)
	public boolean isPalindromeNSpace(ListNode head) {

		if (head == null)
			return true;

		List<Integer> result = new ArrayList<>();

		// add all the values to list
		while (head != null) {
			result.add(head.val);
			head = head.next;
		}

		int i = 0, j = result.size() - 1;

		// start comparing first and last element
		while (i < j) {
			if (!result.get(i).equals(result.get(j)))
				// if not equal - not a palindrome return false
				return false;
			i++;
			j--;
		}

		return true;
	}
	
	 //TC - o(n)
    //SC -o(1)
    public boolean isPalindrome(ListNode head) {
        
        if(head == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        //find the middle of the list
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the list from the middle next
        ListNode revNode = reverseList(slow.next);
        
        //iterate the listNode till we hit null
        while(revNode != null) {
            //compare vals if some same return false
            if(revNode.val != head.val)
                return false;
            head = head.next;
            revNode = revNode.next;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
