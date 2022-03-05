package LinkedList2;

public class ReverseLL2 extends LInkedListUse{
    
    public static DoubleNode reverseLLBetter(Node<Integer> head){

        if(head == null || head.next == null){
            DoubleNode ans = new DoubleNode();
            ans.tail = head;
            ans.head = head;
            return ans;
        }

        DoubleNode smallAns = reverseLLBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;

    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        DoubleNode ans = reverseLLBetter(head);
        print(ans.head);
    }
    
}

 class DoubleNode {
    Node<Integer> head;
    Node<Integer> tail;
    
}

