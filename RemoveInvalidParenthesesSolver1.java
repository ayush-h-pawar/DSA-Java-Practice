import java.util.*;

public class RemoveInvalidParenthesesSolver1 {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (isValid(current)) {

                result.add(current);
                found = true;
            }

            if (found) {
                continue;
            }

            for (int i = 0;
                 i < current.length();
                 i++) {

                char ch = current.charAt(i);

                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next =
                        current.substring(0, i)
                        + current.substring(i + 1);

                if (!visited.contains(next)) {

                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                balance++;

            } else if (ch == ')') {

                if (balance == 0) {
                    return false;
                }

                balance--;
            }
        }

        return balance == 0;
    }

    public static void main(String[] args) {

        RemoveInvalidParenthesesSolver solver =
                new RemoveInvalidParenthesesSolver();

        System.out.println(
                solver.removeInvalidParentheses(
                        "()())()"
                )
        );
    }
}
