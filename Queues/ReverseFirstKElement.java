package Queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Input {
	int n;
	int k;
	Queue<Integer> queue;

	public Input(int n, int k, Queue<Integer> queue) {
		this.queue = queue;
		this.n = n;
		this.k = k;
	}

}

public class ReverseFirstKElement {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {
    	String[] n_k = br.readLine().trim().split(" ");

    	int n = Integer.parseInt(n_k[0]);
    	int k = Integer.parseInt(n_k[1]);

    	String[] values = br.readLine().trim().split(" ");

    	Queue<Integer> queue = new LinkedList<>();

    	for (int i = 0; i < n; i++) {
    		queue.add(Integer.parseInt(values[i]));
    	}

    	return new Input(n, k, queue);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	Input input = takeInput();

    	
    	int k = input.k;
    	Queue<Integer> queue = input.queue;

    	queue = ReverseFirstKElement.reverseKElements(queue, k);


    	while (!queue.isEmpty()) {
    		System.out.print(queue.poll() + " ");
    	}
    }
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        if(input.size() < k || input.isEmpty()){
           return input;
       }   
       if(k <= 0){
           return input;
       }
       
       Stack<Integer> stack = new Stack<>();
       
       for(int i = 0; i<k; i++){
           stack.push(input.poll());
       }
       
      while(!stack.isEmpty()){
          input.add(stack.pop());
      }
       
       for(int i = 0; i < input.size() - k; i++){
           input.add(input.poll());
       }
       return input;
   }
}
