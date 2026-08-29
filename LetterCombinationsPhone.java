import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhone {

    private final String[] mapping = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(
            String digits) {

        List<String> result =
                new ArrayList<>();

        if (digits == null
                || digits.isEmpty()) {

            return result;
        }

        buildCombinations(
                digits,
                0,
                new StringBuilder(),
                result
        );

        return result;
    }

    private void buildCombinations(
            String digits,
            int index,
            StringBuilder current,
            List<String> result) {

        if (index == digits.length()) {

            result.add(
                    current.toString()
            );

            return;
        }

        String letters =
                mapping[
                        digits.charAt(index) - '0'
                ];

        for (char letter :
                letters.toCharArray()) {

            current.append(letter);

            buildCombinations(
                    digits,
                    index + 1,
                    current,
                    result
            );

            current.deleteCharAt(
                    current.length() - 1
            );
        }
    }

    public static void main(String[] args) {

        LetterCombinationsPhone solver =
                new LetterCombinationsPhone();

        System.out.println(
                solver.letterCombinations(
                        "23"
                )
        );
    }
}
