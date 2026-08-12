import java.util.Arrays;

public class LargestNumberComparator {

    public String largestNumber(
            int[] numbers) {

        String[] values =
                new String[numbers.length];

        for (int i = 0;
             i < numbers.length;
             i++) {

            values[i] =
                    String.valueOf(numbers[i]);
        }

        Arrays.sort(
                values,
                (first, second) ->
                        (second + first)
                                .compareTo(
                                        first + second
                                )
        );

        if (values[0].equals("0")) {
            return "0";
        }

        StringBuilder result =
                new StringBuilder();

        for (String value : values) {
            result.append(value);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        LargestNumberComparator solver =
                new LargestNumberComparator();

        int[] numbers = {
                3,
                30,
                34,
                5,
                9
        };

        System.out.println(
                solver.largestNumber(numbers)
        );
    }
}
