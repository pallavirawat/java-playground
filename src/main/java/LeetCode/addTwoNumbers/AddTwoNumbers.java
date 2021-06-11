package LeetCode.addTwoNumbers;

import java.util.LinkedList;
import java.util.List;
//28 minutes
public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            LinkedList<Integer> ll = new LinkedList<>();
            ListNode it1 = l1;
            ListNode it2 = l2;

            int carryOver = 0;
            while (it1!=null && it2!=null){
                int sum = it1.val+ it2.val + carryOver;
                ll.add(sum%10);
                carryOver = sum/10;

                it1=it1.next;
                it2=it2.next;
            }

            if(it1!=null){
                while (it1!=null){
                    int sum = it1.val + carryOver;
                    ll.add(sum%10);
                    carryOver = sum/10;

                    it1=it1.next;
                }
            }
            if(it2!=null){
                while (it2!=null){
                    int sum = it2.val + carryOver;
                    ll.add(sum%10);
                    carryOver = sum/10;
                    it2=it2.next;
                }
            }
            if(carryOver!=0){
                ll.add(carryOver);
            }

            System.out.println("ll is" + ll);
            ListNode result = new ListNode(ll.removeLast());

            while (!ll.isEmpty()){
                result = new ListNode(ll.removeLast(), result);
            }

            return result;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0; //ternary operator
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}


class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



