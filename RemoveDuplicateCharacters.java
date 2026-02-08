public class RemoveDuplicateCharacters {
    static String remove(String s) {
        boolean[] seen = new boolean[256];
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(remove("programming"));
    }
}
