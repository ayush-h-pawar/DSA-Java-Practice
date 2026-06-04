import java.util.*;

public class MyCalendarBookingSystem {

    TreeMap<Integer, Integer> calendar;

    public MyCalendarBookingSystem() {

        calendar = new TreeMap<>();
    }

    public boolean book(
            int start,
            int end) {

        Integer prev =
                calendar.floorKey(start);

        if (prev != null &&
            calendar.get(prev) > start) {

            return false;
        }

        Integer next =
                calendar.ceilingKey(start);

        if (next != null &&
            next < end) {

            return false;
        }

        calendar.put(start, end);

        return true;
    }

    public static void main(String[] args) {

        MyCalendarBookingSystem cal =
                new MyCalendarBookingSystem();

        System.out.println(
                cal.book(10, 20)
        );

        System.out.println(
                cal.book(15, 25)
        );

        System.out.println(
                cal.book(20, 30)
        );
    }
}
