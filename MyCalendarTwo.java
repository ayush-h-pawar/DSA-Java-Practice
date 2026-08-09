import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private final List<int[]> bookings =
            new ArrayList<>();

    private final List<int[]> overlaps =
            new ArrayList<>();

    public boolean book(
            int start,
            int end) {

        // A new triple overlap is not allowed.
        for (int[] overlap : overlaps) {

            if (start < overlap[1]
                    && end > overlap[0]) {

                return false;
            }
        }

        // Record new double overlaps.
        for (int[] booking : bookings) {

            int overlapStart =
                    Math.max(start, booking[0]);

            int overlapEnd =
                    Math.min(end, booking[1]);

            if (overlapStart < overlapEnd) {

                overlaps.add(
                        new int[]{
                                overlapStart,
                                overlapEnd
                        }
                );
            }
        }

        bookings.add(
                new int[]{
                        start,
                        end
                }
        );

        return true;
    }

    public static void main(String[] args) {

        MyCalendarTwo calendar =
                new MyCalendarTwo();

        System.out.println(
                calendar.book(10, 20)
        );

        System.out.println(
                calendar.book(50, 60)
        );

        System.out.println(
                calendar.book(10, 40)
        );

        System.out.println(
                calendar.book(5, 15)
        );

        System.out.println(
                calendar.book(5, 10)
        );

        System.out.println(
                calendar.book(25, 55)
        );
    }
}
