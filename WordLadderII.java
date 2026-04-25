import java.util.*;

public class WordLadderII {

    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord)) return result;

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        level.put(beginWord, 0);

        int wordLen = beginWord.length();

        // BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            int currLevel = level.get(word);

            char[] arr = word.toCharArray();

            for (int i = 0; i < wordLen; i++) {

                char original = arr[i];

                for (char c = 'a'; c <= 'z'; c++) {

                    arr[i] = c;
                    String next = new String(arr);

                    if (dict.contains(next)) {

                        map.computeIfAbsent(next, k -> new ArrayList<>()).add(word);

                        if (!level.containsKey(next)) {
                            level.put(next, currLevel + 1);
                            queue.offer(next);
                        }
                    }
                }

                arr[i] = original;
            }
        }

        // Backtrack
        List<String> path = new ArrayList<>();
        backtrack(endWord, beginWord, map, path, result);

        return result;
    }

    static void backtrack(String word, String beginWord,
                          Map<String, List<String>> map,
                          List<String> path,
                          List<List<String>> result) {

        if (word.equals(beginWord)) {
            path.add(word);
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            path.remove(path.size() - 1);
            return;
        }

        path.add(word);

        if (map.containsKey(word)) {
            for (String prev : map.get(word)) {
                backtrack(prev, beginWord, map, path, result);
            }
        }

        path.remove(path.size() - 1);
    }
                              }
