package com.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSWithTwometric {

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int ROW = 4;
    static int COL = 4;

    // Direction vectors
    static int dRow[] = {-1, 0, 1, 0};
    static int dCol[] = {0, 1, 0, -1};

    static boolean isValid(boolean visited[][], int adjX, int adjY) {
        if (adjX < 0 || adjY < 0 || adjX >= ROW || adjY >= COL)
            return false;
        if (visited[adjX][adjY])
            return false;
        return true;
    }

    static void BFS(int grid[][], boolean visited[][], int row, int col) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            Pair cell = queue.poll();
            int x = cell.first;
            int y = cell.second;

            System.out.print(grid[x][y] + " | ");
            for (int i = 0; i < 4; i++) {
                int adjX = x + dRow[i];
                int adjY = y + dCol[i];
                if (isValid(visited, adjX, adjY)) {
                    queue.add(new Pair(adjX, adjY));
                    visited[adjX][adjY] = true;
                }

            }
        }
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        boolean visited[][] = new boolean[ROW][COL];
        BFS(grid, visited, 0 , 0);
    }
}
