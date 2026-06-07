import java.util.*;

public class PalindromePairsFinder {

    static List<List<Integer>>
    palindromePairs(String[] words) {

        Map<String, Integer> map =
                new HashMap<>();

        for (int i = 0;
             i < words.length;
             i++) {

            map.put(words[i], i);
        }

        List<List<Integer>> result =
                new ArrayList<>();

        for (int i = 0;
             i < words.length;
             i++) {

            String word = words[i];

            for (int j = 0;
                 j <= word.length();
                 j++) {

                String left =
                        word.substring(0, j);

                String right =
                        word.substring(j);

                if (isPalindrome(left)) {

                    String reversed =
                            new StringBuilder(
                                    right
                            ).reverse()
                             .toString();

                    Integer idx =
                            map.get(reversed);

                    if (idx != null &&
                        idx != i) {

                        result.add(
                                Arrays.asList(
                                        idx,
                                        i
                                )
                        );
                    }
                }

                if (right.length() > 0 &&
                    isPalindrome(right)) {

                    String reversed =
                            new StringBuilder(
                                    left
                            ).reverse()
                             .toString();

                    Integer idx =
                            map.get(reversed);

                    if (idx != null &&
                        idx != i) {

                        result.add(
                                Arrays.asList(
                                        i,
                                        idx
                                )
                        );
                    }
                }
            }
        }

        return result;
    }

    static boolean isPalindrome(
            String s) {

        int left = 0;
        int right =
                s.length() - 1;

        while (left < right) {

            if (s.charAt(left) !=
                s.charAt(right)) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    }
