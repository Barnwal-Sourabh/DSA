package Stack;
import java.util.Stack;

public class StackCollection {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int arr[] = {1,3,5,6,7};
        for(int i= 0; i<arr.length; i++){
            stack.push(arr[i]);
        }

        while(stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
