import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeStringStackSolver {

    public String decodeString(String text) {

        Deque<Integer> countStack =
                new ArrayDeque<>();

        Deque<StringBuilder> stringStack =
                new ArrayDeque<>();

        StringBuilder current =
                new StringBuilder();

        int number = 0;

        for (char character :
                text.toCharArray()) {

            if (Character.isDigit(character)) {

                number =
                        number * 10
                        + (character - '0');

            } else if (character == '[') {

                countStack.push(number);
                stringStack.push(current);

                number = 0;
                current =
                        new StringBuilder();

            } else if (character == ']') {

                int repeat =
                        countStack.pop();

                StringBuilder previous =
                        stringStack.pop();

                for (int i = 0;
                     i < repeat;
                     i++) {

                    previous.append(current);
                }

                current = previous;

            } else {

                current.append(character);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {

        DecodeStringStackSolver solver =
                new DecodeStringStackSolver();

        System.out.println(
                solver.decodeString(
                        "3[a2[c]]"
                )
        );
    }
}
