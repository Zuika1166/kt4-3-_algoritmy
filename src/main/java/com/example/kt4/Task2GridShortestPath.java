package com.example.kt4;

import java.util.Arrays;

public final class Task2GridShortestPath {
    private Task2GridShortestPath() {
    }

    public static int shortestPath(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int cells = n * m;
        int start = -1;
        int target = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                char cell = grid[row].charAt(col);

                if (cell == 'S') {
                    start = row * m + col;
                } else if (cell == 'T') {
                    target = row * m + col;
                }
            }
        }

        int[] distance = new int[cells];
        Arrays.fill(distance, -1);
        int[] queue = new int[cells];
        int head = 0;
        int tail = 0;

        distance[start] = 0;
        queue[tail++] = start;

        while (head < tail) {
            int position = queue[head++];

            if (position == target) {
                return distance[position];
            }

            int row = position / m;
            int col = position - row * m;
            int nextDistance = distance[position] + 1;

            if (row > 0) {
                tail = tryVisit(grid, m, position - m, nextDistance, distance, queue, tail);
            }

            if (row + 1 < n) {
                tail = tryVisit(grid, m, position + m, nextDistance, distance, queue, tail);
            }

            if (col > 0) {
                tail = tryVisit(grid, m, position - 1, nextDistance, distance, queue, tail);
            }

            if (col + 1 < m) {
                tail = tryVisit(grid, m, position + 1, nextDistance, distance, queue, tail);
            }
        }

        return -1;
    }

    private static int tryVisit(
        String[] grid,
        int width,
        int position,
        int nextDistance,
        int[] distance,
        int[] queue,
        int tail
    ) {
        if (distance[position] != -1) {
            return tail;
        }

        int row = position / width;
        int col = position - row * width;

        if (grid[row].charAt(col) == '#') {
            return tail;
        }

        distance[position] = nextDistance;
        queue[tail] = position;
        return tail + 1;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next();

            if (grid[i].length() != m) {
                throw new IllegalArgumentException("Invalid row length");
            }
        }

        System.out.println(shortestPath(grid));
    }
}
