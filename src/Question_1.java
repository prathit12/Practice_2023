import java.util.Scanner;

//Given the head of a linked list, remove the nth node from the end of the list and return its head.

class removenode{
    public ListNode remove(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i=0;i<n+1;i++){
            first = first.next;

        }
        while (first!=null){
            first =first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }
}
public class Question_1{
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(" OG Linked List");
        printlinkedlist(head);
        Scanner scanner  =  new Scanner(System.in);
        int n = scanner.nextInt();
        removenode sol = new removenode();

        head=sol.remove(head, n);
        System.out.println("After removal");
        printlinkedlist(head);
        scanner.close();

    }
    public static void printlinkedlist(ListNode head){
        while (head!=null){
            System.out.println(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
}

