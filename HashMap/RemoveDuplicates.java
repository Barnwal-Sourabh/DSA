package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    
    public static ArrayList<Integer> removeDuplicates(int a[]){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Boolean> seen = new HashMap<>();

        for(int i = 0; i<a.length; i++){
            if(seen.containsKey(a[i])){
                continue;
            }
            output.add(a[i]);
            seen.put(a[i], true);
        }

        return output;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1,2,3,3, 10000,5,5};
        ArrayList<Integer> output = removeDuplicates(arr);
        for(int e: output){
            System.out.println(e);
        }
    }
}
