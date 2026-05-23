import java.util.*;

public class MagicDictionaryMatcher {

    Set<String> dictionary;

    public MagicDictionaryMatcher() {

        dictionary = new HashSet<>();
    }

    public void buildDict(String[] words) {

        dictionary.addAll(
                Arrays.asList(words)
        );
    }

    public boolean search(String searchWord) {

        char[] arr =
                searchWord.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            char old = arr[i];

            for (char c = 'a';
                 c <= 'z';
                 c++) {

                if (c == old)
                    continue;

                arr[i] = c;

                if (dictionary.contains(
                        new String(arr)
                )) {

                    return true;
                }
            }

            arr[i] = old;
        }

        return false;
    }

    public static void main(String[] args) {

        MagicDictionaryMatcher md =
                new MagicDictionaryMatcher();

        md.buildDict(
                new String[]{
                        "hello",
                        "leetcode"
                }
        );

        System.out.println(
                md.search("hhllo")
        );
    }
}
