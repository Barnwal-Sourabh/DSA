package Graphs;

import java.io.*;
import java.util.*;

public class IsConnected {
	public static boolean isConnected(int edges[][], int sv, boolean visted[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visted[sv] = true;
        
        while(!q.isEmpty()){
            int front = q.remove();
            for(int i = 0; i<edges.length; i++){
                if(edges[front][i] == 1 && !visted[i]){
                    q.add(i);
                    visted[i] = true;
                }
            }
        }
        
        for(boolean item: visted){
            if(item == false){
                return false;
            }
        }
        return true;
    }
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
       	int n;
    	int e; 
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        int edges[][] = new int[n][n];
        
        for(int i =0; i<e; i++){
            int fv = sc.nextInt();         
            int sv = sc.nextInt();         
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        
        boolean visted[] = new boolean[edges.length];
        
        if(n == 0){
			System.out.println("true");
        }else {
            System.out.println(isConnected(edges, 0, visted));
        }
        sc.close();
	}

}