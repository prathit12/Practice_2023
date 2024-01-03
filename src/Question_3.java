//Write a program to find the node at which the intersection of two singly linked lists begins.
// If there is no intersection, return null.
class IntersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}
public class Question_3 {
    public static void main(String[] args) {
        ListNode head_1 = new ListNode(1);
        ListNode h_1 = new ListNode(2);
        ListNode h_2 = new ListNode(3);
        ListNode com_1 = new ListNode(4);
        ListNode com_2 = new ListNode(5);

        head_1.next=h_1;
        h_1.next=h_2;
        h_2.next=com_1;
        com_1.next=com_2;
        com_2.next=null;

        ListNode head_2 = new ListNode(8);
        ListNode h2_1 = new ListNode(7);
        ListNode h2_2 = new ListNode(6);

        head_2.next=h2_1;
        h2_1.next=h2_2;
        h2_2.next=com_1;
        System.out.println("Linked List A:");
        printLinkedList(head_1);

        System.out.println("\nLinked List B:");
        printLinkedList(head_2);

        // Find the intersection point
        IntersectionOfTwoLists solution = new IntersectionOfTwoLists();
        ListNode intersectionNode = solution.getIntersectionNode(head_1, head_2);

        System.out.println("\nIntersection Point Value: " + intersectionNode.val);
    }

    // Helper method to print the linked list
    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
