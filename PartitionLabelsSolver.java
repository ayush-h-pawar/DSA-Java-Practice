import java.util.ArrayList;
import java.util.List;

public class PartitionLabelsSolver {

    public List<Integer> partitionLabels(
            String text) {

        int[] lastOccurrence =
                new int[26];

        for (int i = 0;
             i < text.length();
             i++) {

            lastOccurrence[
                    text.charAt(i) - 'a'
            ] = i;
        }

        List<Integer> partitions =
                new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0;
             i < text.length();
             i++) {

            end = Math.max(
                    end,
                    lastOccurrence[
                            text.charAt(i) - 'a'
                    ]
            );

            if (i == end) {

                partitions.add(
                        end - start + 1
                );

                start = i + 1;
            }
        }

        return partitions;
    }

    public static void main(String[] args) {

        PartitionLabelsSolver solver =
                new PartitionLabelsSolver();

        String text =
                "ababcbacadefegdehijhklij";

        List<Integer> result =
                solver.partitionLabels(text);

        System.out.println(result);
    }
}
