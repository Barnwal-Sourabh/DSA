package DynamicProgramming;

public class LCS {
    //Recursion
    public static int lcs(String s, String t){
        if(s.length() == 0 || t.length() == 0){
            return 0;
        }
        if(s.charAt(0) == t.charAt(0)){
            return 1 + lcs(s.substring(1), t.substring(1));
        }else {
            int opt1 = lcs(s, t.substring(1));
            int opt2 = lcs(s.substring(1), t);
            return Math.max(opt1, opt2);
        }
    }

    //Memoization
    public static int lcsM(String s, String t){
        int[][] storage = new int[s.length() + 1][t.length() + 1];

        for(int i =0; i<s.length() + 1; i++){
            for(int j =0; j<t.length()+1; j++){
                storage[i][j] = -1;
            }
        }

        return lcsM(s, t, storage);
    }
    private static int lcsM(String s, String t, int[][] storage) {
        int m = s.length();
        int n = t.length();
        
        if(storage[m][n] != -1){
            return storage[m][n];
        }

        if(m == 0 || n == 0){
            storage[m][n] = 0;
            return storage[m][n];
        }

        if(s.charAt(0) == t.charAt(0)){
            storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage);
        }else {
            int opt1 = lcsM(s, t.substring(1), storage);
            int opt2 = lcsM(s.substring(1), t, storage);
            storage[m][n] = Math.max(opt1,opt2);
        }
        return storage[m][n];

    }
    //Dynamic approch
    public static int lcsDP(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] storage = new int[m + 1][n + 1]; 

        for(int i =0; i<=m; i++){
            storage[i][0] = 0;
        }
        for(int j =0; j<=n; j++){
            storage[0][j] = 0;
        }

        for(int i =1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(s.charAt(m-i) == t.charAt(n-j)){
                    storage[i][j] = 1 + storage[i-1][j-1];
                }else {
                    storage[i][j] = Math.max(storage[i][j-1], storage[i-1][j]);
                }
            }
        }
        return storage[m][n];
    }
    public static void main(String[] args) {
        String s = "adg";
        String t = "bag";

        System.out.println(lcsDP(s, t));
        System.out.println(lcsM(s, t));
        System.out.println(lcs(s, t));
    }    
}
