package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExtractUniqueCharacter {   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String takeInput() throws IOException {
        String str = br.readLine(); 
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(ExtractUniqueCharacter.uniqueChar(str));


    }

    public static String uniqueChar(String str){
		HashMap<Character, Boolean> map = new HashMap<>();
        String ans = "";
        
        for(int i =0; i<str.length(); i++){
            char temp = str.charAt(i);
            if(map.containsKey(temp)){
                continue;
            }
            ans += temp;
            map.put(temp, true);
            
        }
		return ans;
	}
    
    
}
