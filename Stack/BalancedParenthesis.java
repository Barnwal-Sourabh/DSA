package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class BalancedParenthesis {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(BalancedParenthesis.isBalanced(expression));
    }
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<expression.length(); i++){
            char c = expression.charAt(i);

            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(c == '}' || c == ']' || c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() == pair(c)){
                    stack.pop();
                }else {
                    return false;
                }

            }
        }

        return stack.isEmpty();
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