//Addition when data is stored in Linked List form.

class ListNode {

    int val;
    ListNode next;

    ListNode(int val ){
        this.val = val;
    }
    ListNode(int  val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class addTwonumbers{
    public ListNode add(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry  = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
        }

        return dummy.next;
    }
}

public class Question_2 {
    public static void main(String[] args) {


        ListNode L1 = new ListNode(4, new ListNode(1));
        ListNode L2 = new ListNode(3, new ListNode(0));
        System.out.println("Linked List 1");
        printLinkedList(L1);
        System.out.println("Linked List 2");
        printLinkedList(L2);

        addTwonumbers sol = new addTwonumbers();
        ListNode res = sol.add(L1,L2);

        System.out.println("addition result ");
        printLinkedList(res);


    }
    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}