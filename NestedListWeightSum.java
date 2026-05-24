import java.util.*;

public class NestedListWeightSum {

    interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    static int depthSum(
            List<NestedInteger> nestedList) {

        return dfs(nestedList, 1);
    }

    static int dfs(
            List<NestedInteger> list,
            int depth) {

        int sum = 0;

        for (NestedInteger ni : list) {

            if (ni.isInteger()) {

                sum +=
                        ni.getInteger() * depth;

            } else {

                sum += dfs(
                        ni.getList(),
                        depth + 1
                );
            }
        }

        return sum;
    }
}
