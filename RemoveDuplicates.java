public class RemoveDuplicates {
    static int remove(int[] arr) {
        int j = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1; // new length
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,4,4};
        int len = remove(a);

        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
