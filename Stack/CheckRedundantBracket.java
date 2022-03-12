package Stack;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckRedundantBracket {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

    	String expression = br.readLine().trim();
    	System.out.println(CheckRedundantBracket.checkRedundantBrackets(expression));
    }
    
	public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        boolean ans = false;
        for(int i = 0; i < expression.length(); i++){
            int count = 0;
            if(expression.charAt(i) != ')'){
                stack.push(expression.charAt(i));
            }
            if(expression.charAt(i) == ')'){
                while(stack.peek() != '('){
                    stack.pop();
                    count++;
                }
                stack.pop();
                if(count <= 1){
                    return true;
                }
            }
        }
        return ans;
        
	}
    public static char pair(char c){
        if(c == ')'){
            return '(';
        }else if(c == '}'){
            return '{';
        }else if(c == ']'){
            return '[';
        }else{
            return '\0';
        }
    }
}