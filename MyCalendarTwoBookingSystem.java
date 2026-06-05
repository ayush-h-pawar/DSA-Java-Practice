import java.util.*;

public class MyCalendarTwoBookingSystem {

    List<int[]> bookings;
    List<int[]> overlaps;

    public MyCalendarTwoBookingSystem() {

        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start,
                        int end) {

        for (int[] overlap : overlaps) {

            if (start < overlap[1] &&
                end > overlap[0]) {

                return false;
            }
        }

        for (int[] booking : bookings) {

            if (start < booking[1] &&
                end > booking[0]) {

                overlaps.add(
                        new int[]{
                                Math.max(start,
                                         booking[0]),
                                Math.min(end,
                                         booking[1])
                        }
                );
            }
        }

        bookings.add(
                new int[]{start, end}
        );

        return true;
    }

    public static void main(String[] args) {

        MyCalendarTwoBookingSystem cal =
                new MyCalendarTwoBookingSystem();

        System.out.println(
                cal.book(10, 20)
        );

        System.out.println(
                cal.book(50, 60)
        );

        System.out.println(
                cal.book(10, 40)
        );

        System.out.println(
                cal.book(5, 15)
        );
    }
  }
