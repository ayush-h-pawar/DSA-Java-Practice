import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation1 {

    private static final char[] GENES = {
            'A', 'C', 'G', 'T'
    };

    public int minMutation(
            String startGene,
            String endGene,
            String[] bank) {

        Set<String> validGenes =
                new HashSet<>();

        for (String gene : bank) {
            validGenes.add(gene);
        }

        if (!validGenes.contains(endGene)) {
            return -1;
        }

        Queue<String> queue =
                new LinkedList<>();

        Set<String> visited =
                new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String current =
                        queue.poll();

                if (current.equals(endGene)) {
                    return mutations;
                }

                char[] genes =
                        current.toCharArray();

                for (int i = 0;
                     i < genes.length;
                     i++) {

                    char original =
                            genes[i];

                    for (char gene : GENES) {

                        if (gene == original) {
                            continue;
                        }

                        genes[i] = gene;

                        String next =
                                new String(genes);

                        if (validGenes.contains(next)
                                && !visited.contains(next)) {

                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    genes[i] = original;
                }
            }

            mutations++;
        }

        return -1;
    }

    public static void main(String[] args) {

        MinimumGeneticMutation solver =
                new MinimumGeneticMutation();

        String start = "AACCGGTT";

        String end = "AAACGGTA";

        String[] bank = {
                "AACCGGTA",
                "AACCGCTA",
                "AAACGGTA"
        };

        System.out.println(
                solver.minMutation(
                        start,
                        end,
                        bank
                )
        );
    }
}
