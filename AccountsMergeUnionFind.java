import java.util.*;

public class AccountsMergeUnionFind {

    static class DisjointSet {

        private final int[] parent;
        private final int[] rank;

        DisjointSet(int size) {

            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {

            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        void union(int first, int second) {

            int rootFirst = find(first);
            int rootSecond = find(second);

            if (rootFirst == rootSecond) {
                return;
            }

            if (rank[rootFirst] < rank[rootSecond]) {

                parent[rootFirst] = rootSecond;

            } else if (rank[rootFirst] > rank[rootSecond]) {

                parent[rootSecond] = rootFirst;

            } else {

                parent[rootSecond] = rootFirst;
                rank[rootFirst]++;
            }
        }
    }

    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        int n = accounts.size();

        DisjointSet dsu =
                new DisjointSet(n);

        Map<String, Integer> emailOwner =
                new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<String> account =
                    accounts.get(i);

            for (int j = 1;
                 j < account.size();
                 j++) {

                String email =
                        account.get(j);

                if (!emailOwner.containsKey(email)) {

                    emailOwner.put(email, i);

                } else {

                    dsu.union(
                            i,
                            emailOwner.get(email)
                    );
                }
            }
        }

        Map<Integer, TreeSet<String>> merged =
                new HashMap<>();

        for (String email : emailOwner.keySet()) {

            int root =
                    dsu.find(emailOwner.get(email));

            merged
                    .computeIfAbsent(
                            root,
                            key -> new TreeSet<>())
                    .add(email);
        }

        List<List<String>> answer =
                new ArrayList<>();

        for (int root : merged.keySet()) {

            List<String> account =
                    new ArrayList<>();

            account.add(
                    accounts.get(root).get(0)
            );

            account.addAll(
                    merged.get(root)
            );

            answer.add(account);
        }

        return answer;
    }

    public static void main(String[] args) {

        AccountsMergeUnionFind solver =
                new AccountsMergeUnionFind();

        List<List<String>> accounts =
                Arrays.asList(

                        Arrays.asList(
                                "John",
                                "johnsmith@mail.com",
                                "john_newyork@mail.com"
                        ),

                        Arrays.asList(
                                "John",
                                "johnsmith@mail.com",
                                "john00@mail.com"
                        ),

                        Arrays.asList(
                                "Mary",
                                "mary@mail.com"
                        ),

                        Arrays.asList(
                                "John",
                                "johnnybravo@mail.com"
                        )
                );

        List<List<String>> result =
                solver.accountsMerge(accounts);

        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}
