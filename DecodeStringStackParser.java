import java.util.*;

public class DecodeStringStackParser {

    static String decodeString(String s) {

        Stack<Integer> countStack =
                new Stack<>();

        Stack<StringBuilder> strStack =
                new Stack<>();

        StringBuilder current =
                new StringBuilder();

        int k = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {

                k = k * 10 + (c - '0');

            } else if (c == '[') {

                countStack.push(k);

                strStack.push(current);

                current =
                        new StringBuilder();

                k = 0;

            } else if (c == ']') {

                StringBuilder decoded =
                        strStack.pop();

                int repeat =
                        countStack.pop();

                for (int i = 0;
                     i < repeat;
                     i++) {

                    decoded.append(current);
                }

                current = decoded;

            } else {

                current.append(c);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {

        System.out.println(
                decodeString("3[a2[c]]")
        );
    }
}
