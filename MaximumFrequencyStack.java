import java.util.*;

public class MaximumFrequencyStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {

        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        maxFreq = Math.max(maxFreq, f);

        group
            .computeIfAbsent(f, k -> new Stack<>())
            .push(val);
    }

    public int pop() {

        int val = group.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);

        if (group.get(maxFreq).isEmpty())
            maxFreq--;

        return val;
    }
}
