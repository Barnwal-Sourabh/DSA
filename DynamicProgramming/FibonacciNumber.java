package DynamicProgramming;

class FibonnaciNumber{

    public static int fib(int n){
        int storage[] = new int[n+1];
        for(int i =0; i<n+1; i++){
            storage[i] = -1;
        } 
        return fib(n, storage);
    }
    //Top down approch
    private static int fib(int n, int[] storage) {
        if(n == 0 || n == 1){
            storage[n] = n;
            return storage[n];
        }

        if(storage[n] != -1){
            return storage[n];
        }
        storage[n] = fib(n-1, storage) + fib(n-2, storage);
        return storage[n];
    }

    //Bottom up approch(Dynamic Programming)
    public static int fibDP(int n){
        int storage[] = new int[n+1];
        storage[0] = 0;
        storage[1] = 1;

        for(int i = 2; i<=n; i++){
            storage[i] = storage[i-1] + storage[i-2];
        }
        return storage[n];
    }
    
    public static void main(String[] args) {
        int n = fibDP(5);
        System.out.println(n);
    }
}
