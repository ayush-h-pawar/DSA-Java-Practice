public class ReverseString {
    static String reverse(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;

        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++; r--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
