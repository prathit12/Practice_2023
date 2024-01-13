import java.util.Scanner;

//In the Josephus problem, there are N people (numbered from 1 to N) sitting in a circle.
// tarting from the 1st person, every kth person is skipped until only one person remains.
// The task is to find the position of the last person remaining.
public class Question_6 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k  = sc.nextInt();

        Josephus sol = new Josephus();
        int res = sol.josephus(n,k,head);
        System.out.println(res);

    }
}

class Josephus{
    public static void printCircularLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("Circular linked list is empty.");
            return;
        }

        ListNode current = head;

        do {
            System.out.print(current.val + " ");
            current = current.next;
        } while (current != head);

        System.out.println();  // Move to the next line after printing all elements
    }

        public  int josephus(int n, int k, ListNode head){

            ListNode curr = head;
            for (int i=2; i<=n;i++){
                curr.next= new ListNode(i);
                curr=curr.next;
            }
            curr.next=head;
            printCircularLinkedList(curr.next);
            while (curr.next!=curr){
                for (int i = 1; i < k - 1; i++) {
                    curr = curr.next;
                }
                curr.val = curr.next.val;
                curr.next = curr.next.next;
            }

            return curr.val;
        }

}

