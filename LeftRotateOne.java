public class LeftRotateOne {
    static void rotate(int[] arr) {
        int first = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        rotate(a);

        for (int x : a) System.out.print(x + " ");
    }
}
