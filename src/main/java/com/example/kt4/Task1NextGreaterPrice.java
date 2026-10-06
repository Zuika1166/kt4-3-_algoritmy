package com.example.kt4;

public final class Task1NextGreaterPrice {
    private Task1NextGreaterPrice() {
    }

    public static int[] daysUntilHigher(int[] prices) {
        int[] result = new int[prices.length];
        int[] stack = new int[prices.length];
        int top = -1;

        for (int i = 0; i < prices.length; i++) {
            while (top >= 0 && prices[i] > prices[stack[top]]) {
                int index = stack[top--];
                result[index] = i - index;
            }

            stack[++top] = i;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int[] result = daysUntilHigher(prices);
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                output.append(' ');
            }

            output.append(result[i]);
        }

        System.out.println(output);
    }
}
