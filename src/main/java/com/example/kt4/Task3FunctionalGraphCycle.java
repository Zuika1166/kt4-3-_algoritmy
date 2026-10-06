package com.example.kt4;

public final class Task3FunctionalGraphCycle {
    private Task3FunctionalGraphCycle() {
    }

    public static boolean hasRepeatedNode(int[] next, int start) {
        int slow = start - 1;
        int fast = start - 1;

        while (true) {
            slow = step(next, slow);
            fast = step(next, step(next, fast));

            if (slow == -1 || fast == -1) {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }
    }

    private static int step(int[] next, int current) {
        if (current == -1) {
            return -1;
        }

        int value = next[current];
        return value == -1 ? -1 : value - 1;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = scanner.nextInt();
        }

        System.out.println(hasRepeatedNode(next, start) ? "YES" : "NO");
    }
}
