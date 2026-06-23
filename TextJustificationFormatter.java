import java.util.*;

public class TextJustificationFormatter {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {

            int totalChars = words[index].length();
            int last = index + 1;

            while (last < words.length) {

                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }

                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int gaps = last - index - 1;

            if (last == words.length || gaps == 0) {

                for (int i = index; i < last; i++) {
                    line.append(words[i]);

                    if (i < last - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                int wordsLength = 0;

                for (int i = index; i < last; i++) {
                    wordsLength += words[i].length();
                }

                int spaces = maxWidth - wordsLength;
                int evenSpaces = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int i = index; i < last - 1; i++) {

                    line.append(words[i]);

                    for (int j = 0; j < evenSpaces; j++) {
                        line.append(" ");
                    }

                    if (extraSpaces > 0) {
                        line.append(" ");
                        extraSpaces--;
                    }
                }

                line.append(words[last - 1]);
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }

    public static void main(String[] args) {

        TextJustificationFormatter formatter =
                new TextJustificationFormatter();

        String[] words = {
                "This", "is", "an", "example",
                "of", "text", "justification."
        };

        List<String> result =
                formatter.fullJustify(words, 16);

        for (String line : result) {
            System.out.println("|" + line + "|");
        }
    }
}
