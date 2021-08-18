
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


/*

Algo:

    Traverse the linkedlists from the start to the end

    Add the two digits each from the respective linked lists

    If one of the list has reached the end then take 0 as its digit

    Continue it until botht the lists end

    If the sum of two digits is greater then 9, then set carry as 1
        and the current digit as sum % 10

*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
        ListNode res = null;
        ListNode prev = null;
        ListNode tmp = null;

        int carry = 0, sum = 0;

        // while both the lists exists
        while (l1 != null || l2 != null) {

            // calculate value of the next digit in the resultant list
            // the next digit is the sum of the following things
                // carry
                // next digit of l1 (if exists)
                // next digit of l2 (if exists)

            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            // update carry for the next calculation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // create a new node with the sum as the data
            tmp = new ListNode(sum);

            // if this is the first node then set it as the head of the resultant list
            if (res == null)
                res = tmp;

            // else connect it to the rest
            else prev.next = tmp;

            // set prev for the next insertion
            prev = tmp;

            if (l1 != null) l1 = l1.next;

            if (l2 != null) l2 = l2.next;

            if (carry > 0) tmp.next = new ListNode(carry);

        }

        return res;

    }
}