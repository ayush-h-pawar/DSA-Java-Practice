import java.util.*;

public class RestoreIPAddressesGenerator {

    static List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), s, 0);

        return result;
    }

    static void backtrack(List<String> result,
                          List<String> parts,
                          String s,
                          int index) {

        if (parts.size() == 4 && index == s.length()) {

            result.add(String.join(".", parts));
            return;
        }

        if (parts.size() == 4)
            return;

        for (int len = 1; len <= 3 &&
             index + len <= s.length(); len++) {

            String part =
                    s.substring(index,
                                index + len);

            if ((part.length() > 1 &&
                 part.startsWith("0")) ||
                Integer.parseInt(part) > 255) {

                continue;
            }

            parts.add(part);

            backtrack(result,
                      parts,
                      s,
                      index + len);

            parts.remove(parts.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(
                restoreIpAddresses("25525511135")
        );
    }
}
