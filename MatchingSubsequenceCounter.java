import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MatchingSubsequenceCounter {

    private static class Cursor {
        private final String word;
        private int index;

        Cursor(String word) {
            this.word = word;
        }
    }

    // The source and words contain lowercase English letters.
    public int numMatchingSubseq(String s, String[] words) {
        List<ArrayDeque<Cursor>> waiting = new ArrayList<>(26);
        for (int letter = 0; letter < 26; letter++) {
            waiting.add(new ArrayDeque<>());
        }

        int matches = 0;
        for (String word : words) {
            if (word.isEmpty()) {
                matches++;
            } else {
                waiting.get(word.charAt(0) - 'a').addLast(new Cursor(word));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            ArrayDeque<Cursor> queue = waiting.get(s.charAt(i) - 'a');
            // Cursors that rejoin this queue must wait for another source character.
            int ready = queue.size();
            for (int j = 0; j < ready; j++) {
                Cursor cursor = queue.removeFirst();
                cursor.index++;
                if (cursor.index == cursor.word.length()) {
                    matches++;
                } else {
                    int next = cursor.word.charAt(cursor.index) - 'a';
                    waiting.get(next).addLast(cursor);
                }
            }
        }

        return matches;
    }
}

// Time Complexity: O(s.length() + words.length + total word length)
// Space Complexity: O(words.length)
