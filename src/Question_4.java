//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null; // Important to avoid cycle in the result

        before.next = afterHead.next;

        return beforeHead.next;
    }
}

public class Question_4 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));

        System.out.println("Original Linked List:");
        printLinkedList(head);
        int x = 3;
        PartitionList solution = new PartitionList();
        ListNode result = solution.partition(head, x);

        System.out.println("\nLinked List after Partition (x = " + x + "):");
        printLinkedList(result);
    }


    private static void printLinkedList(ListNode head) {
        for (ListNode current = head; current != null; current = current.next) {
            System.out.print(current.val + " ");
        }
        System.out.println();
    }
}

