package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class PairSumToZero {
    
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        public static int[] takeInput() throws IOException {
            int size = Integer.parseInt(br.readLine().trim());
            int[] input = new int[size];
    
            if (size == 0) {
                return input;
            }
            
            String[] strNums;
            strNums = br.readLine().split("\\s");
            
            for (int i = 0; i < size; ++i) {
                input[i] = Integer.parseInt(strNums[i]);
            }
    
            return input;
        }
    
        public static void printArray(int[] arr) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
    
            System.out.println();
        }
    
        public static void main(String[] args) throws NumberFormatException, IOException {
    
    
            int[] arr = takeInput();
            System.out.print(PairSumToZero.PairSum(arr,arr.length));
    
    
        }

        public static int PairSum(int[] arr1, int size) {
        //     if(size==0){
        //        return 0;
        //    }
        //    int ans = 0;
        //    HashMap<Integer,Integer> h = new HashMap<>();
        //    for(int i=0;i<size;i++)
        //    {   
        //        if(h.containsKey(-input[i]) && h.get(-input[i])!=0){
        //            int count = h.get(-input[i]);
        //            while(count!=0){
        //                ans++;
        //                 count--;
        //            }
        //            if(h.containsKey(input[i]))
        //                h.put(input[i],h.get(input[i])+1);
        //            else
        //                h.put(input[i],1);
        //        }
        //        else{
        //            if(h.containsKey(input[i])){
        //                h.put(input[i],h.get(input[i])+1);
        //            }else{
        //                h.put(input[i] ,1);
        //            }
        //        }
        //    }
        //    return ans;
        HashMap<Integer,Integer> map = new HashMap<>();
        int finalCount = 0;
        for(int i = 0; i<arr1.length; i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }else {
                map.put(arr1[i], 1);
            }
        }
        for(int i = 0; i<size; i++){
            int key = arr1[i];
            if(map.containsKey(-key) && map.get(key) != 0){
                int times;
                if(key == (-key)){
                    int occurences = map.get(key);
                    times = (occurences * (occurences -1)) / 2;
                    finalCount = finalCount + times;
                    map.put(key, 0);
                    continue;
                    }
                times = map.get(key) * map.get(-key);
                finalCount = finalCount + times;
                map.put(key, 0);
                map.put(-key, 0);
            }
        }
        return finalCount;
    }
}
           


