package BackTracking;

/*
	Note:
	To get all the test cases accepted, make recursive calls in following order: Top, Down, Left, Right.
	This means that if the current cell is (x, y), then order of calls should be: top cell (x-1, y), 
	down cell (x+1, y), left cell (x, y-1) and right cell (x, y+1).
*/  

public class RatInAMazeAllPaths {

	static void printsolution(int[][] solution, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(solution[i][j] + " ");
            }
        }
    }
    static void solveMaze(int maze[][], int solution[][], int x, int y, int n)
    {
        if (x == n - 1 && y == n - 1)
        {
            solution[x][y] = 1;
            printsolution(solution, n);
            System.out.println();
            return;
        }
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0)
        {
            return;
        }
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0 || maze[x][y] == 0 || solution[x][y] == 1)
        {
            return;
        }
        solution[x][y] = 1;
        solveMaze(maze, solution, x - 1, y, n);
        solveMaze(maze, solution, x + 1, y, n);
        solveMaze(maze, solution, x, y - 1, n);
        solveMaze(maze, solution, x, y + 1, n);
        solution[x][y] = 0;
    }
    
    static void ratInAMaze(int maze[][], int n)
    {
        int[][] solution = new int[20][20];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                solution[i][j] = 0;
            }
        }
        solveMaze(maze, solution, 0, 0, n);
    }
	    

}