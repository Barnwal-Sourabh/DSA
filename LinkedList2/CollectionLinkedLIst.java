

import java.util.LinkedList;

/**
 * CollectionLinkedLIst
 */
public class CollectionLinkedLIst {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addFirst(30);
        list.set(1, 5);
        list.add(1, 2);
        list.clone();

        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i) +" ");
        }
        

    }
}
