package Problem2;

/* PROBLEM 2
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * 
 * Add the two numbers and return the sum as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/


	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public class AddTwoNumbers {
		public static void main(String[] args) {
			ListNode l3 = new ListNode(3,null);
			ListNode l2 = new ListNode(4,l3);
			ListNode l1 = new ListNode(2,l2);
			ListNode r3 = new ListNode(4,null);
			ListNode r2 = new ListNode(6,r3);
			ListNode r1 = new ListNode(5,r2);
			AddTwoNumbers s = new AddTwoNumbers();
			ListNode answer = s.addTwoNumbers(l1, r1);
			for(ListNode a = answer; a != null; a = a.next) {
				System.out.println(a.val);
			}
			
		}

	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode v1 = l1;
	        ListNode v2 = l2;
	        ListNode num = new ListNode(0);
	        ListNode v3 = num;
	        int carry = 0;
	        while(v1 != null || v2 != null){
	            int n1 = (v1 != null) ? v1.val : 0;
	            int n2 = (v2 != null) ? v2.val : 0;

	            int sum = n1 + n2 + carry;
	            carry = sum/10;
	            v3.next = new ListNode(sum % 10);
	            v3 = v3.next;
	            if(v1 != null) {
	                v1 = v1.next;
	            }
	            if(v2 != null) {
	                v2 = v2.next;
	            }

	            if(carry > 0){
	                v3.next = new ListNode(carry);
	            }
	        }
	        return num.next;
	    }
	}

