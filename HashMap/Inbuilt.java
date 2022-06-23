package HashMap;

import java.util.HashMap;
import java.util.Set;

public class Inbuilt {
    
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        //insert
        map.put("abc", 1);
        map.put("def", 2);
        map.put("abc", 10);
        map.put("mno", 4);

        System.out.println("size :" +map.size());

        //check presence
        if(map.containsKey("abc")){
            System.out.println("Has abc");
        }

        if(map.containsKey("kal")){
            System.out.println("has kal");
        }

        if(map.containsValue(2)){
            System.out.println("Has value 2");
        }

        //get value
        int v = 0;
        if(map.containsKey("mno")){
            v = map.get("mno");
        }
        System.out.println(v);

        //remove
        int s = map.remove("abc");
        System.out.println("removed :" +s);
    
        //iterate
        Set<String> keys = map.keySet();
        for(String str : keys){
            System.out.println(str);
        }
    }



}
