package com.example.kt4;

public final class Task6FindDuplicate {
    private Task6FindDuplicate() {
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(findDuplicate(nums));
    }
}
