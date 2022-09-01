

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KReverse {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            LinkedListNode<Integer> head = takeInput();
            int k = Integer.parseInt(br.readLine().trim());

            LinkedListNode<Integer> newHead = KReverse.kReverse(head, k);
            print(newHead);
            
            t -= 1;
        }

    }
    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		LinkedListNode<Integer> head1 = head, tail = head, head2;
        int count = 1;

        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        if(k==0){
            return head;
        }

        while(count < k && tail.next != null){
            tail = tail.next;
            count++;
        }
        head2 = tail.next;
        tail.next = null;

        DoubleNode ans = reverseLLBetter(head1);
        LinkedListNode<Integer> smallHead = kReverse(head2, k);
        ans.tail.next = smallHead;
        return ans.head;
       

	}
    public static DoubleNode reverseLLBetter(LinkedListNode<Integer> head){

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

}

class DoubleNode {
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
    
}
