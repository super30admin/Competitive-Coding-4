package codes;

public class Solution_Palindrome_LL {
//	 TC-O(n)  SP-O(1)
    private ListNode getHalf(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        // ListNode next=null;
        
        while (curr!=null){
            ListNode next= curr.next;
            curr.next=prev;
            
            prev=curr;
            
            curr=next;
            
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        
        
        ListNode fhalf=getHalf(head);
        ListNode shalf=reverseLinkedList(fhalf.next);
        
        // palindrome
        
        
        ListNode p1=head;
        ListNode p2=shalf;
        
        boolean result=true;
        
        while(p2!=null){
            if (p1.val!=p2.val) return false;
            p1=p1.next;
            p2=p2.next;
        }
        
        
        return true;
        
        
    }
    
    
    
    // approach 2
    
//    TC-O(n)  SP-O(n)
//    save to array and palindrome
    
    public boolean isPalindrome2(ListNode head) {
        List<Integer> val= new ArrayList<>();
        
        ListNode temp=head;
        while (temp!=null){
            val.add(temp.val);
            temp=temp.next;
        }
        
        int st=0;
        int et=val.size()-1;
        
        // System.out.println(val);
        
        while (st<et){
            if(!val.get(st).equals(val.get(et))){
                return false;
            }
            st++;
            et--;
        }
        
        return true;
        
    }
    
    
}
