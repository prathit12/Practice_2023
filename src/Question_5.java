//Merge two sorted linked lists and return it as a new sorted list.
// The new list should be made by splicing together the nodes of the first two lists.
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If one of the lists is not empty, append the remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }
}

public class Question_5 {
    public static void main(String[] args) {
        ListNode head_1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));

        ListNode head_2 = new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(4, new ListNode(9))))));

        System.out.println("Original Linked List: 1");
        printLinkedList(head_1);
        System.out.println("Original Linked List: 2:");
        printLinkedList(head_2);

        MergeTwoLists solution = new MergeTwoLists();
        ListNode result = solution.mergeTwoLists(head_1, head_2);

        System.out.println("\nLinked List after Merge: ");
        printLinkedList(result);
    }


    private static void printLinkedList(ListNode head) {
        for (ListNode current = head; current != null; current = current.next) {
            System.out.print(current.val + " ");
        }
        System.out.println();
    }
}
