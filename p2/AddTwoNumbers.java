/*
 * 2. Add Two Numbers


Favorite

Share
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/package p2;

  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 =l1;
        ListNode t2 =l2;
        ListNode B= new ListNode(0);
        ListNode B1 =B;
        int carry =0;
        while(t1!=null||t2!=null)
        {
            int a = t1!=null?t1.val:0;
            int b = t2!=null?t2.val:0;
            int sum = a+b+carry;
            // if(sum>=10){
             // B.next= new ListNode(sum%10);
                carry =sum/10;
            // }else{
                B.next= new ListNode(sum%10);
            // }
            B=B.next;
            if(t1!=null)
            t1=t1.next;
            if(t2!=null)
            t2=t2.next;
        }
        if(carry>0){
            B.next = new ListNode(carry);
        }
        
        return B1.next;
    }
}
