package Graphs;

import java.util.*;
import java.io.*;

public class BFSTraversal {
    
    public static void printHelper(int edges[][], int sv, boolean visited[]){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()){
        	int fv = q.remove();
            System.out.print(fv + " ");
            for(int i = 0; i < edges.length; i++){
                if(edges[fv][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public static void print(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(!visited[i]){
                printHelper(edges,i,visited);
            }
        }
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        int edges[][] = new int[v][v];
        for(int i = 0; i < e; i++){
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        print(edges);
        sc.close();
	}
}