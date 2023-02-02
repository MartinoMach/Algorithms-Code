package Problem25;

/* PROBLEM 25
 * 
 Given the head of a linked list, reverse the nodes of the list k at a time, 
 and return the modified list.
 
 k is a positive integer and is less than or equal to the length of the linked list. 
 
 If the number of nodes is not a multiple of k then left-out nodes, 
 in the end, should remain as it is.
 
 You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

	Example 1:
	
	
	Input: head = [1,2,3,4,5], k = 2
	Output: [2,1,4,3,5]
	Example 2:
	
	
	Input: head = [1,2,3,4,5], k = 3
	Output: [3,2,1,4,5]
 */



  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode cur=dummy;
        ListNode temp=dummy;
        ListNode prev=dummy;

        int count=0;
        while(cur.next!=null){
            cur=cur.next;
            count++;
        }

        while(count>=k){
            cur=prev.next;
            temp=cur.next;

            for(int i=1;i<k;i++){
                cur.next=temp.next;
                temp.next=prev.next;
                prev.next=temp;
                temp=cur.next;
            }
            prev=cur;
            count-=k;
        }
        return dummy.next;
        
    }
}