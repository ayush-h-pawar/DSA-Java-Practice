import java.util.HashSet;

public class LongestConsecutiveSequence {

    static int longest(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr)
            set.add(num);

        int longestStreak = 0;

        for (int num : set) {

            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longest(arr)); // 4 (1,2,3,4)
    }
}
