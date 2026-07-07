public class SatisfiabilityEquationSolver {

    static class DisjointSet {

        private final int[] parent;

        DisjointSet() {

            parent = new int[26];

            for (int i = 0; i < 26; i++) {
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

            if (rootFirst != rootSecond) {
                parent[rootFirst] = rootSecond;
            }
        }
    }

    public boolean equationsPossible(
            String[] equations) {

        DisjointSet dsu =
                new DisjointSet();

        for (String equation : equations) {

            if (equation.charAt(1) == '=') {

                int first =
                        equation.charAt(0) - 'a';

                int second =
                        equation.charAt(3) - 'a';

                dsu.union(first, second);
            }
        }

        for (String equation : equations) {

            if (equation.charAt(1) == '!') {

                int first =
                        equation.charAt(0) - 'a';

                int second =
                        equation.charAt(3) - 'a';

                if (dsu.find(first)
                        == dsu.find(second)) {

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        SatisfiabilityEquationSolver solver =
                new SatisfiabilityEquationSolver();

        String[] equations1 = {
                "a==b",
                "b!=c",
                "c==a"
        };

        System.out.println(
                solver.equationsPossible(equations1)
        );

        String[] equations2 = {
                "a==b",
                "b==c",
                "a==c"
        };

        System.out.println(
                solver.equationsPossible(equations2)
        );
    }
}
