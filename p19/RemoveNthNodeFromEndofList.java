/*
 * 19. Remove Nth Node From End of List
 * 
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?*/
package p19;

public class RemoveNthNodeFromEndofList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			int l = 0;
			ListNode temp = head;
			ListNode t2 = head;
			while (temp != null) {
				l++;
				temp = temp.next;
			}
			int p = l - n;
			if (p == 0 && l <= 1) {
				return null;
			} else if (p == 0) {
				return head.next;
			} else {
				while (t2 != null && p != 1) {
					t2 = t2.next;
					p--;
				}
				if (t2.next.next != null) {
					t2.next = t2.next.next;

				} else {
					t2.next = null;
				}
				return head;

			}

		}
	}
}
