

class ReverseItrative extends LInkedListUse{

    public static Node<Integer> reverse_I(Node<Integer> head){

        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> temp;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = reverse_I(head);
        print(head);
    }
}