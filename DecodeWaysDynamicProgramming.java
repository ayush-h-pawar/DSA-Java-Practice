public class DecodeWaysDynamicProgramming {

    public int numDecodings(String text) {

        if (text == null
                || text.length() == 0
                || text.charAt(0) == '0') {

            return 0;
        }

        int previousTwo = 1;
        int previousOne = 1;

        for (int index = 1;
             index < text.length();
             index++) {

            int current = 0;

            char currentDigit =
                    text.charAt(index);

            char previousDigit =
                    text.charAt(index - 1);

            if (currentDigit != '0') {

                current += previousOne;
            }

            int twoDigitNumber =
                    (previousDigit - '0') * 10
                    + (currentDigit - '0');

            if (twoDigitNumber >= 10
                    && twoDigitNumber <= 26) {

                current += previousTwo;
            }

            previousTwo =
                    previousOne;

            previousOne =
                    current;
        }

        return previousOne;
    }

    public static void main(String[] args) {

        DecodeWaysDynamicProgramming solver =
                new DecodeWaysDynamicProgramming();

        String text = "226";

        System.out.println(
                solver.numDecodings(text)
        );
    }
}
