import java.util.HashMap;

public class TaskScheduler {

    static int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char t : tasks) {
            freq[t - 'A']++;
        }

        int max = 0, maxCount = 0;

        for (int f : freq) {
            if (f > max) {
                max = f;
                maxCount = 1;
            } else if (f == max) {
                maxCount++;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n)); // 8
    }
              }
