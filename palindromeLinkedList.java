// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        //base case
        if(head==null||head.next==null)
            return true;
        //initialize 4pointers for slow, fast, current and previous nodes
        ListNode s=head, f=head, c=head, p=null;
        while(f!=null && f.next!=null){
            //we assign current nodes to slow and slow will be moved by 1node
            c=s;
            s=s.next;
            //then fast will move by 2nodes
            f=f.next.next;
            c.next=p;
            p=c;
        }
        if(f!=null)
            s=s.next;
        while(p!=null && p.val==s.val){
            p=p.next;
            s=s.next;
        }
        return(p==null);
    }
}