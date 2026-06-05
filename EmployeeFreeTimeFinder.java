import java.util.*;

public class EmployeeFreeTimeFinder {

    static class Interval {

        int start;
        int end;

        Interval(int s, int e) {

            start = s;
            end = e;
        }
    }

    static List<Interval> employeeFreeTime(
            List<List<Interval>> schedule) {

        List<Interval> all =
                new ArrayList<>();

        for (List<Interval> employee :
                schedule) {

            all.addAll(employee);
        }

        all.sort(
                Comparator.comparingInt(
                        a -> a.start
                )
        );

        List<Interval> result =
                new ArrayList<>();

        Interval current = all.get(0);

        for (int i = 1;
             i < all.size();
             i++) {

            Interval next = all.get(i);

            if (current.end <
                next.start) {

                result.add(
                        new Interval(
                                current.end,
                                next.start
                        )
                );

                current = next;

            } else {

                current.end =
                        Math.max(
                                current.end,
                                next.end
                        );
            }
        }

        return result;
    }
}
