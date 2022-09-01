

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteEveryNNodes {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }

    public static void print(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput();
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]);
            int n = Integer.parseInt(m_n[1]);

            LinkedListNode<Integer> newHead = DeleteEveryNNodes.skipMdeleteN(head, m, n);
            print(newHead);

            t -= 1;
        }

    }

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {

       if(head == null || M == 0){
            return null;
       }
       if(N == 0){
            return head;
       }

       LinkedListNode<Integer> temp1 = head;
       LinkedListNode<Integer> temp2 = null;

       while(temp1 != null){
           int c1 = 0;
           int c2 = 0;

           while(temp1 !=null && c1 < M){
               if(temp2 == null){
                   temp2 = temp1;
               }else{
                   temp2.next = temp1;
                   temp2 = temp1;
               }
               temp1 = temp1.next;
               c1++;
           }

           while(temp1 != null && c2 < N){
               temp1 = temp1.next;
               c2++;
           }
       }

       if(temp2 != null){
           temp2.next = null;
       }

       return head;
    }
}
