import java.util.*;

public class JobSchedulerWeightedProfit {

    static class Job {

        int start;
        int end;
        int profit;

        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }

    static int jobScheduling(int[] startTime,
                             int[] endTime,
                             int[] profit) {

        int n = startTime.length;

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {

            jobs[i] = new Job(
                    startTime[i],
                    endTime[i],
                    profit[i]
            );
        }

        Arrays.sort(jobs,
                Comparator.comparingInt(a -> a.start));

        int[] dp = new int[n];

        return dfs(0, jobs, dp);
    }

    static int dfs(int index,
                   Job[] jobs,
                   int[] dp) {

        if (index >= jobs.length)
            return 0;

        if (dp[index] != 0)
            return dp[index];

        int next =
                findNextJob(
                        jobs,
                        jobs[index].end
                );

        int take =
                jobs[index].profit +
                dfs(next, jobs, dp);

        int skip =
                dfs(index + 1,
                    jobs,
                    dp);

        return dp[index] =
                Math.max(take, skip);
    }

    static int findNextJob(Job[] jobs,
                           int endTime) {

        int left = 0;
        int right = jobs.length - 1;

        int ans = jobs.length;

        while (left <= right) {

            int mid =
                    left +
                    (right - left) / 2;

            if (jobs[mid].start >= endTime) {

                ans = mid;
                right = mid - 1;

            } else {

                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] start = {1,2,3,3};
        int[] end = {3,4,5,6};
        int[] profit = {50,10,40,70};

        System.out.println(
                jobScheduling(
                        start,
                        end,
                        profit
                )
        );
    }
  }
