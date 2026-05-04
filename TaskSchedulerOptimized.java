import java.util.*;

public class TaskSchedulerOptimized {

    // O(1) counting approach
    static int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        Arrays.sort(freq);

        int max = freq[25] - 1;                 // gaps created by most frequent task
        int idleSlots = max * n;

        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleSlots -= Math.min(freq[i], max);
        }

        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }

    public static void main(String[] args) {

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        System.out.println(leastInterval(tasks, n)); // 8
    }
}
