package Problem24;

/* PROBLEM 24
 *
 *Given a linked list, swap every two adjacent nodes and return its head. 
 *
 *You must solve the problem without modifying the values in the list's nodes 
 *(i.e., only nodes themselves may be changed.)

 

	Example 1:
	
	
	Input: head = [1,2,3,4]
	Output: [2,1,4,3]
	
 */



 class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Prpblem24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tempNext = head.next.next;
        ListNode tempFirst = head.next;
        ListNode tempSecond = head;
        head = tempFirst;
        head.next = tempSecond;
        head.next.next = swapPairs(tempNext);
        return head;
    }
}