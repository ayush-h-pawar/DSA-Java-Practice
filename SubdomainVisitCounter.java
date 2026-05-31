import java.util.*;

public class SubdomainVisitCounter {

    static List<String> subdomainVisits(
            String[] cpdomains) {

        Map<String, Integer> map =
                new HashMap<>();

        for (String domain :
                cpdomains) {

            String[] parts =
                    domain.split(" ");

            int count =
                    Integer.parseInt(
                            parts[0]
                    );

            String fullDomain =
                    parts[1];

            String[] sections =
                    fullDomain.split("\\.");

            String current = "";

            for (int i =
                 sections.length - 1;
                 i >= 0;
                 i--) {

                if (current.isEmpty()) {

                    current =
                            sections[i];

                } else {

                    current =
                            sections[i]
                            + "." +
                            current;
                }

                map.put(
                        current,
                        map.getOrDefault(
                                current,
                                0
                        ) + count
                );
            }
        }

        List<String> result =
                new ArrayList<>();

        for (String key :
                map.keySet()) {

            result.add(
                    map.get(key)
                    + " "
                    + key
            );
        }

        return result;
    }

    public static void main(String[] args) {

        String[] domains = {
                "9001 discuss.leetcode.com"
        };

        System.out.println(
                subdomainVisits(domains)
        );
    }
}
