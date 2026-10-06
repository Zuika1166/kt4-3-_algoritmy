package com.example.kt4;

public final class Task4MaximalRectangle {
    private Task4MaximalRectangle() {
    }

    public static int maximalRectangle(String[] matrix) {
        if (matrix.length == 0 || matrix[0].isEmpty()) {
            return 0;
        }

        int columns = matrix[0].length();
        int[] heights = new int[columns];
        int[] stack = new int[columns];
        int best = 0;

        for (String row : matrix) {
            for (int col = 0; col < columns; col++) {
                if (row.charAt(col) == '1') {
                    heights[col]++;
                } else {
                    heights[col] = 0;
                }
            }

            best = Math.max(best, largestHistogram(heights, stack));
        }

        return best;
    }

    private static int largestHistogram(int[] heights, int[] stack) {
        int top = -1;
        int best = 0;

        for (int i = 0; i <= heights.length; i++) {
            int current = i == heights.length ? 0 : heights[i];

            while (top >= 0 && heights[stack[top]] > current) {
                int height = heights[stack[top--]];
                int left = top >= 0 ? stack[top] : -1;
                int width = i - left - 1;
                best = Math.max(best, height * width);
            }

            if (i < heights.length) {
                stack[++top] = i;
            }
        }

        return best;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] matrix = new String[n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.next();

            if (matrix[i].length() != m) {
                throw new IllegalArgumentException("Invalid row length");
            }
        }

        System.out.println(maximalRectangle(matrix));
    }
}
