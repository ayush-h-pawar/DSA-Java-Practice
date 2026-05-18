import java.util.*;

public class MinimumGeneticMutation {

    static int minMutation(String startGene,
                           String endGene,
                           String[] bank) {

        Set<String> valid =
                new HashSet<>(Arrays.asList(bank));

        if (!valid.contains(endGene))
            return -1;

        char[] genes = {'A', 'C', 'G', 'T'};

        Queue<String> queue =
                new LinkedList<>();

        queue.offer(startGene);

        Set<String> visited =
                new HashSet<>();

        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String curr = queue.poll();

                if (curr.equals(endGene))
                    return mutations;

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char old = arr[j];

                    for (char g : genes) {

                        arr[j] = g;

                        String next =
                                new String(arr);

                        if (valid.contains(next) &&
                            !visited.contains(next)) {

                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[j] = old;
                }
            }

            mutations++;
        }

        return -1;
    }

    public static void main(String[] args) {

        String start = "AACCGGTT";
        String end = "AACCGGTA";

        String[] bank = {
                "AACCGGTA"
        };

        System.out.println(
                minMutation(start, end, bank)
        );
    }
}
