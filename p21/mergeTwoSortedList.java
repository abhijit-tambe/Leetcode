

/*21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 * */
package p21;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class mergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode T= new ListNode(0);
        merge(l1,l2,T);
        return T.next;
    }
    
    
    public void merge(ListNode p,ListNode q,ListNode t){
        if(p==null&&q!=null){
            t.next=q;
            return;
        }
        if(p!=null&&q==null){
            t.next=p;
            return;
        }
        if(p==null&&q==null){
            return;
        }
        if(p.val<=q.val){
            t.next =p;
            p=p.next;
        }else{
            t.next =q;
            q=q.next;
        }
        t=t.next;
        merge(p,q,t);
    }
}
