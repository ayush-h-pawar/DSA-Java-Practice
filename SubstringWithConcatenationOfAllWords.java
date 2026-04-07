import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        Map<String, Integer> wordCount = new HashMap<>();

        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {

            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {

                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > wordCount.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == words.length) {
                        result.add(left);
                    }

                } else {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
                                          }
