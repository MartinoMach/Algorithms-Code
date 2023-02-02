package Problem23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/* PROBLEM 23
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

	Example 1:
	
	Input: lists = [[1,4,5],[1,3,4],[2,6]]
	Output: [1,1,2,3,4,4,5,6]
	Explanation: The linked-lists are:
	[
	  1->4->5,
	  1->3->4,
	  2->6
	]
	merging them into one sorted list:
	1->1->2->3->4->4->5->6
	Example 2:
	
	Input: lists = []
	Output: []
 */



 class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean empty = false;
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                empty = true;
                break;
            }
        }
        if(!empty) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        ArrayList<Integer> array = new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<>();
        for(int i = 0; i < lists.length; i++) {
            ListNode var = lists[i];
            while(var != null) {
                array.add(var.val);
                var = var.next;
            }
        }
        Collections.sort(array);
        for(int i = array.size() - 1; i >= 0; i--) {
            int val = array.get(i);
            stack.push(new ListNode(val));
        }
        ListNode head = stack.pop();
        ListNode temp = head;
        while(!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}