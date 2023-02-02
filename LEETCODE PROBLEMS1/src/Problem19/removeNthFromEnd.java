package Problem19;


/* PROBLEM 19
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

	Example 1:
	
	Input: head = [1,2,3,4,5], n = 2
	Output: [1,2,3,5]

 * 
 */


 	class ListNode {
 		 int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	class Problem19 {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        int counter = 0, i = 0;
	        ListNode num = head, temp;
	        while(num != null) {
	            num = num.next;
	            counter++;
	        }
	        if(n == counter) {
	            return head.next;
	        }
	        num = head;
	        while(i < counter - n- 1) {
	            num = num.next;
	            i++;
	        }
	        temp = num;
	        temp.next = temp.next.next;
	        return head;

	    }
	}