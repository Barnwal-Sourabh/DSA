package Stack;

public class StackUse {
    
    public static void main(String[] args) throws StackFullExeception {
        
        StackUssingArray stack = new StackUssingArray(3);
        for(int i = 1; i<=5; i++){
            stack.push(i);
        }

        while(!stack.isEmpty()){
            try {
                System.out.println(stack.pop());
            } catch (StackEmptyException e) {
                //Never reach here
                e.printStackTrace();
            }
        }
    }
}
