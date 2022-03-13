package Stack;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumBracketReversal {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.out.println(MinimumBracketReversal.countBracketReversals(br.readLine().trim()));

    }

    public static int countBracketReversals(String input) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char c1, c2;

        if (input.length() % 2 == 0) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '{') {
                    stack.push(c);
                }
                if (c == '}') {
                    if (stack.size() == 0) {
                        stack.push(c);
                    } else if (stack.peek() == '{') {
                        stack.pop();
                    } else if (stack.size() != 0 && stack.peek() != '{') {
                        stack.push(c);
                    }
                }

            }
        } else {
            return -1;
        }

        if (stack.size() % 2 == 0) {
            while (stack.size() != 0) {
                c1 = stack.pop();
                c2 = stack.pop();
                if (c1 == c2) {
                    count++;
                } else {
                    count = count + 2;
                }
            }
        }
        return count;

    }
}