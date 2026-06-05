import java.util.*;

public class MeetingSchedulerCommonSlot {

    static List<Integer> minAvailableDuration(
            int[][] slots1,
            int[][] slots2,
            int duration) {

        Arrays.sort(
                slots1,
                Comparator.comparingInt(
                        a -> a[0]
                )
        );

        Arrays.sort(
                slots2,
                Comparator.comparingInt(
                        a -> a[0]
                )
        );

        int i = 0;
        int j = 0;

        while (i < slots1.length &&
               j < slots2.length) {

            int start =
                    Math.max(
                            slots1[i][0],
                            slots2[j][0]
                    );

            int end =
                    Math.min(
                            slots1[i][1],
                            slots2[j][1]
                    );

            if (end - start >= duration) {

                return Arrays.asList(
                        start,
                        start + duration
                );
            }

            if (slots1[i][1] <
                slots2[j][1]) {

                i++;

            } else {

                j++;
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {

        int[][] slots1 = {
                {10, 50},
                {60, 120},
                {140, 210}
        };

        int[][] slots2 = {
                {0, 15},
                {60, 70}
        };

        System.out.println(
                minAvailableDuration(
                        slots1,
                        slots2,
                        8
                )
        );
    }
}
