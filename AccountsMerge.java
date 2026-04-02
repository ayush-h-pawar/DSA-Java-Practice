import java.util.*;

public class AccountsMerge {

    static List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> emailToIndex = new HashMap<>();

        // Step 1: Union accounts with same email
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                if (emailToIndex.containsKey(email)) {
                    uf.union(i, emailToIndex.get(email));
                } else {
                    emailToIndex.put(email, i);
                }
            }
        }

        // Step 2: Group emails by root
        Map<Integer, List<String>> map = new HashMap<>();

        for (String email : emailToIndex.keySet()) {

            int root = uf.find(emailToIndex.get(email));

            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(email);
        }

        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();

        for (int root : map.keySet()) {

            List<String> emails = map.get(root);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(root).get(0)); // name
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com")
        );

        System.out.println(accountsMerge(accounts));
    }
                             }
