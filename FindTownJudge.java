public class FindTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] relation : trust) {
            int person = relation[0];
            int judge = relation[1];

            score[person]--;
            score[judge]++;
        }

        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}

// Time Complexity: O(n + m), where m is trust.length
// Space Complexity: O(n)
// LeetCode: 997 - Find the Town Judge
