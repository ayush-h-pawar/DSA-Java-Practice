public class CountRangeSum {

    static int countRangeSum(
            int[] nums,
            int lower,
            int upper) {

        long[] prefix =
                new long[nums.length + 1];

        for (int i = 0;
             i < nums.length;
             i++) {

            prefix[i + 1] =
                    prefix[i] + nums[i];
        }

        return mergeSort(
                prefix,
                0,
                prefix.length - 1,
                lower,
                upper
        );
    }

    static int mergeSort(
            long[] arr,
            int left,
            int right,
            int lower,
            int upper) {

        if (left >= right)
            return 0;

        int mid =
                left +
                (right - left) / 2;

        int count =
                mergeSort(
                        arr,
                        left,
                        mid,
                        lower,
                        upper
                )
                +
                mergeSort(
                        arr,
                        mid + 1,
                        right,
                        lower,
                        upper
                );

        int start = mid + 1;
        int end = mid + 1;

        for (int i = left;
             i <= mid;
             i++) {

            while (start <= right &&
                    arr[start] - arr[i]
                    < lower) {

                start++;
            }

            while (end <= right &&
                    arr[end] - arr[i]
                    <= upper) {

                end++;
            }

            count += end - start;
        }

        long[] temp =
                new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid &&
                j <= right) {

            if (arr[i] <= arr[j]) {

                temp[k++] =
                        arr[i++];

            } else {

                temp[k++] =
                        arr[j++];
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        System.arraycopy(
                temp,
                0,
                arr,
                left,
                temp.length
        );

        return count;
    }

    public static void main(String[] args) {

        int[] nums =
                {-2,5,-1};

        System.out.println(
                countRangeSum(
                        nums,
                        -2,
                        2
                )
        );
    }
        }
