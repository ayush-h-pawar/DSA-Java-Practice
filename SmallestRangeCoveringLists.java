import java.util.*;

public class SmallestRangeCoveringLists {

    static int[] smallestRange(
            List<List<Integer>> nums) {

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(
                        Comparator.comparingInt(a -> a[0])
                );

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {

            int val = nums.get(i).get(0);

            minHeap.offer(
                    new int[]{val, i, 0}
            );

            max = Math.max(max, val);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (minHeap.size() == nums.size()) {

            int[] curr = minHeap.poll();

            int min = curr[0];

            if (max - min < end - start) {

                start = min;
                end = max;
            }

            int row = curr[1];
            int col = curr[2];

            if (col + 1 <
                nums.get(row).size()) {

                int next =
                        nums.get(row)
                            .get(col + 1);

                max = Math.max(max, next);

                minHeap.offer(
                        new int[]{
                                next,
                                row,
                                col + 1
                        }
                );
            }
        }

        return new int[]{start, end};
    }
                  }
