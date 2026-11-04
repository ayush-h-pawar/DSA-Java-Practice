public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        int count = 0;

        for (char ch : sentence.toCharArray()) {
            int index = ch - 'a';

            if (!seen[index]) {
                seen[index] = true;
                count++;
            }

            if (count == 26) {
                return true;
            }
        }

        return false;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
