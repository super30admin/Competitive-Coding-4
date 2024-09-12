package linkedlistQ;

public class PalindromeLL {
	 public boolean isPalindrome(ListNode head) {
		    ListNode slow=head;
		        ListNode fast=head.next;
		        
		        while(fast!=null && fast.next!=null){
		            slow=slow.next;
		            fast=fast.next.next;
		        } 
		       //reverse LL
		        ListNode compareHead=slow.next;
		        slow.next=null;
		        ListNode p1=null;
		        ListNode p2=compareHead;
		        ListNode p3;
		        
		        while(p2!=null){
		            p3=p2.next;
		            p2.next=p1;
		            p1=p2;
		            p2=p3;   
		        }
		        compareHead=p1;
		        while(head!=null && compareHead!=null){
		            if(head.val==compareHead.val){
		                head=head.next;
		                compareHead=compareHead.next;
		            }
		            else{
		                return false;
		            }
		            
		        }
		        return true;
		        
		    }

}
