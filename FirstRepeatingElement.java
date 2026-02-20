import java.util.HashSet;

public class FirstRepeatingElement {

    static int find(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 3, 5, 6};
        System.out.println(find(arr));
    }
}
