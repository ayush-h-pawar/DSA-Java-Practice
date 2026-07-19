import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(
            int[] people,
            int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        int boats = 0;

        while (left <= right) {

            if (people[left]
                    + people[right]
                    <= limit) {

                left++;
            }

            right--;
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {

        BoatsToSavePeople solver =
                new BoatsToSavePeople();

        int[] people = {
                3,
                2,
                2,
                1
        };

        System.out.println(
                solver.numRescueBoats(
                        people,
                        3
                )
        );
    }
}
