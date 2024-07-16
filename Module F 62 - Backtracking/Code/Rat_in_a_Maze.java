package Module_62_Backtracking;

import java.security.spec.RSAOtherPrimeInfo;

public class Rat_in_a_Maze {

    public static void printSolution(int[][] output, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isSafe(int[][] maze, int i, int j, int n){
        if(i>=0 && i<n && j<n && j>=0 && maze[i][j] == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean solveMaze(int[][] maze, int[][] output, int i, int j, int n){
        //base case
        if(i == n-1 && j == n-1 && maze[i][j] == 1){
            output[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j, n) == true){
            //check if this path already path of solution or not
            if (output[i][j] == 1){
                return false;
            }

            //otherwise mark it as part of solution
            output[i][j] = 1;

            //right direction
             if(solveMaze(maze, output, i+1, j, n) == true){
                 return true;
             }

            //bottom direction
            if (solveMaze(maze, output, i, j+1, n) == true){
                return true;
            }

            //backtrack
            output[i][j] = 0;
            return false;

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        int n = maze.length;

        int[][] output = new int[n][n];

        if(solveMaze(maze, output, 0, 0, n) == true){
            printSolution(output, n);
        }else {
            System.out.println("Solution does not exist.");
        }
    }
}
