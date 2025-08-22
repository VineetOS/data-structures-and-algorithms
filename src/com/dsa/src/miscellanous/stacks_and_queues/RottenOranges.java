package com.dsa.src.miscellanous.stacks_and_queues;

import java.util.Deque;
import java.util.LinkedList;

public class RottenOranges {

    static int rottenOranges(int[][] grid){
        if(grid==null || grid.length==0 || grid[0].length==0) return -1;
        int totalOranges = 0;
        int time = 0;
        int fresh = 0, countConverted=0, totalConverted=0;
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] != 0) totalOranges++;
                if(grid[i][j] == 1) fresh++;
            }
        }

        if(totalOranges == 0 || queue.isEmpty()) return -1; // No oranges at all or no rotten oranges to start with
        if(fresh == 0) return 0; // No fresh oranges to rot

        while(!queue.isEmpty()){
            int size = queue.size();
            countConverted = 0; // Reset count for each time unit
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                assert curr != null;
                int x = curr[0];
                int y = curr[1];

                // Check all 4 directions
                if(x > 0 && grid[x-1][y] == 1){ // Up
                    grid[x-1][y] = 2;
                    queue.offer(new int[]{x-1, y});
                    countConverted++;
                }
                if(x < rows-1 && grid[x+1][y] == 1){ // Down
                    grid[x+1][y] = 2;
                    queue.offer(new int[]{x+1, y});
                    countConverted++;
                }
                if(y > 0 && grid[x][y-1] == 1){ // Left
                    grid[x][y-1] = 2;
                    queue.offer(new int[]{x, y-1});
                    countConverted++;
                }
                if(y < cols-1 && grid[x][y+1] == 1){ // Right
                    grid[x][y+1] = 2;
                    queue.offer(new int[]{x, y+1});
                    countConverted++;
                }
            }
            if(countConverted > 0) time++; // Increment time only if at least one orange was converted
            totalConverted += countConverted;
        }
        if(totalConverted < fresh) {
            return -1; // Not all fresh oranges could be converted
        }
        return time; // Return the total time taken to rot all oranges
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 0},
            {0, 1, 0},
            {1, 0, 2}
        };
        int result = rottenOranges(grid);
        System.out.println("Time taken to rot all oranges: " + result);
        // Expected output: Time taken to rot all oranges: 2
    }
}
