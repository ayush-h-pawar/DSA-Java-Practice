public class MoveZeros {
    static void move(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        move(a);

        for (int x : a) System.out.print(x + " ");
    }
}
