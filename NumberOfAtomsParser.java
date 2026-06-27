import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtomsParser {

    public String countOfAtoms(String formula) {

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        int index = 0;

        while (index < formula.length()) {

            char current = formula.charAt(index);

            if (current == '(') {

                stack.push(new TreeMap<>());
                index++;

            } else if (current == ')') {

                index++;

                int multiplier = 0;

                while (index < formula.length()
                        && Character.isDigit(formula.charAt(index))) {

                    multiplier =
                            multiplier * 10
                                    + formula.charAt(index) - '0';

                    index++;
                }

                if (multiplier == 0) {
                    multiplier = 1;
                }

                Map<String, Integer> top =
                        stack.pop();

                Map<String, Integer> previous =
                        stack.peek();

                for (String atom : top.keySet()) {

                    previous.put(
                            atom,
                            previous.getOrDefault(atom, 0)
                                    + top.get(atom) * multiplier
                    );
                }

            } else {

                StringBuilder atom =
                        new StringBuilder();

                atom.append(current);
                index++;

                while (index < formula.length()
                        && Character.isLowerCase(
                        formula.charAt(index))) {

                    atom.append(formula.charAt(index));
                    index++;
                }

                int count = 0;

                while (index < formula.length()
                        && Character.isDigit(
                        formula.charAt(index))) {

                    count =
                            count * 10
                                    + formula.charAt(index) - '0';

                    index++;
                }

                if (count == 0) {
                    count = 1;
                }

                Map<String, Integer> map =
                        stack.peek();

                map.put(
                        atom.toString(),
                        map.getOrDefault(
                                atom.toString(),
                                0
                        ) + count
                );
            }
        }

        StringBuilder answer =
                new StringBuilder();

        for (String atom : stack.peek().keySet()) {

            answer.append(atom);

            int count =
                    stack.peek().get(atom);

            if (count > 1) {
                answer.append(count);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        NumberOfAtomsParser parser =
                new NumberOfAtomsParser();

        System.out.println(
                parser.countOfAtoms("H2O")
        );

        System.out.println(
                parser.countOfAtoms("Mg(OH)2")
        );

        System.out.println(
                parser.countOfAtoms("K4(ON(SO3)2)2")
        );
    }
}
