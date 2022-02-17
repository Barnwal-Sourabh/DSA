package LinkedList2;
public class InsertRecusively extends LInkedListUse{
    
    public static Node<Integer> insert(Node<Integer> head, int pos, int elem){
        if(pos == 0){
            Node<Integer> newhead = new Node<>(elem);
            newhead.next = head;
            return newhead;
        }

        if(head == null){
            return head;
        }

        head.next = insert(head.next, pos-1, elem);
        return head;
    }
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = insert(head, 5, 10);
        print(head);
    }
    
}
