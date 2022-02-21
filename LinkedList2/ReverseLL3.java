package LinkedList2;

public class ReverseLL3 extends LInkedListUse {

    public static Node<Integer> reverseLLR(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> reverseTail = head.next;
        Node<Integer> smallHead = reverseLLR(head.next);
        reverseTail.next = head;
        head.next = null;
        return smallHead;
    }

    public static void main(String[] args) {
        
        Node<Integer> head = takeInput();
        head = reverseLLR(head);
        print(head);
    }
}