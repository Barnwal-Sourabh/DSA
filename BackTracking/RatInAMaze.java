package BackTracking;

import java.util.Scanner;

public class RatInAMaze {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		System.out.println(RatInAMaze.ratInAMaze(maze));
        s.close();	
	}
    public static boolean ratInAMaze(int maze[][]){
        
        int path[][] = new int[maze.length][maze.length];
		return ratInAMaze(maze, 0, 0, path);

	}
    
    public static boolean ratInAMaze(int maze[][], int i, int j, int path[][]){
        
        int n = maze.length;
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }
        
        path[i][j] = 1;
        
        if(i == n-1 && j == n-1){
            path[i][j] = 0;
            return true;
        }
        
        boolean pathPossible = false; 
        
        if(ratInAMaze(maze, i-1, j, path)){
            pathPossible = true;
        }else if(ratInAMaze(maze, i, j+1, path)){
            pathPossible = true;
        }else if(ratInAMaze(maze, i+1, j, path)){
            pathPossible = true;
        }else if(ratInAMaze(maze, i, j-1, path)){
            pathPossible = true;
        }
        
        return pathPossible;
    }

}
